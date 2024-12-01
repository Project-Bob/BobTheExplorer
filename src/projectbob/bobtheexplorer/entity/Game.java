package projectbob.bobtheexplorer.entity;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Hero hero;
    private Monster monster;
    private final Inventory inventory;
    private int difficultyMonster;
    private int difficultyHero;
    private final Dungeon dungeon;
    private char[][] currentRoom;
    private int roomNumber;
    private int numMonstersDefeated = 0;
    private int numMove = 0;
    private int numAction = 0;

    public Game(Hero hero, Inventory inventory, int difficultyMonster, int difficultyHero) {
        this.hero = hero;
        this.inventory = inventory;
        this.difficultyMonster = difficultyMonster;
        this.difficultyHero = difficultyHero;
        this.dungeon = new Dungeon();
        Random random = new Random();
        this.roomNumber = random.nextInt(dungeon.room.size());
        this.currentRoom = dungeon.room.get(roomNumber);
    }

    public int getNumMonstersDefeated() {
        return numMonstersDefeated;
    }

    public void incrementMonstersDefeated() {
        numMonstersDefeated++;
    }

    public int getNumMove(){
        return numMove;
    }

    public int getNumAction(){
        return numAction;
    }
    public void incrementNumAction(){
        numAction++;
    }

    final int Dungeon_size = 10;
    int heroX = 4;
    int heroY = 3;
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        while (playing) {

            if(hero.getHP()<=0){
                System.out.println("Hero is dead");
                return;
            }
            if (currentRoom[heroX][heroY] == 'E') {
                System.out.println("You have entered the next room!");

                // Reinitialize rooms and move to the next room
                dungeon.initializeRooms();
                int nextRoom;
                Random random = new Random();
                do {
                    nextRoom = random.nextInt(dungeon.room.size());
                } while (nextRoom == roomNumber);
                roomNumber = nextRoom;

                currentRoom = dungeon.room.get(roomNumber);
                heroX = 4;
                heroY = 3;
                currentRoom[heroX][heroY] = 'H'; // Set new position
            }

            dungeon.displayDungeon(currentRoom);
            System.out.println("\nUse W, A, S, D to move.");
            System.out.print("Enter your move (W=up, A=left, S=down, D=right, Q=quit):");
            char move = scanner.next().toUpperCase().charAt(0);
            numMove++;

            switch (move) {
                case 'W' -> HeroMove(-1, 0, currentRoom);
                case 'S' -> HeroMove(1, 0, currentRoom);
                case 'A' -> HeroMove(0, -1, currentRoom);
                case 'D' -> HeroMove(0, 1, currentRoom);
                case 'Q' -> {
                    playing = false;
                    System.out.println("Exiting the game. Goodbye!");
                }
                default -> System.out.println("Invalid input!");
            }
        }

        scanner.close();
    }
    //controller for hero to move
    public void HeroMove(int dx, int dy, char[][] currentRoom) {

        Random random = new Random();
        int newX = heroX + dx;
        int newY = heroY + dy;
        int typeMonster = 0;

        //change the position of hero and if encounter the wall,display can't move message
        if (newX >= 0 && newX <= Dungeon_size && newY >= 0 && newY <=Dungeon_size && currentRoom[newX][newY] != '#') {
            char targetTile = currentRoom[newX][newY];
            if (targetTile == 'M') {
                System.out.println("\nYou encounter a monster!");
                typeMonster = switch (difficultyMonster) {
                    case 1 -> random.nextInt(1, 4);
                    case 2 -> random.nextInt(4, 7);
                    case 3 -> random.nextInt(7, 10);
                    default -> typeMonster;
                };
                switch(typeMonster){
                    case 1 : monster = new GoblinLevel1("GoblinLevel1", 30, 10, 10);break;
                    case 2 : monster = new SlimeLevel1("SlimeLevel1", 25, 20, 5);break;
                    case 3 : monster = new SpiderLevel1("SpiderLevel1", 20, 10, 20);break;
                    case 4 : monster = new GoblinLevel2("GoblinLevel2", 35, 15, 10);break;
                    case 5 : monster = new SlimeLevel2("SlimeLevel2", 30, 25, 5);break;
                    case 6 : monster = new SpiderLevel2("SpiderLevel2", 25, 10, 25);break;
                    case 7 : monster = new GoblinLevel3("GoblinLevel3", 40, 20, 10);break;
                    case 8 : monster = new SlimeLevel3("SlimeLevel3", 35, 30, 5);break;
                    case 9 : monster = new SpiderLevel3("SpiderLevel3", 30, 15, 25);break;

                }
                BattleStatus battlestatus = new BattleStatus(hero, monster,inventory,this);
                battlestatus.displayBattleStatus();
            }
            else if (targetTile == 'I') {
                int randomItem = random.nextInt(2); // Random number: 0 or 1
                System.out.print("\nYou found an item!");

                // Create a random item
                Item item;
                if (randomItem == 0) {
                    item = new Potion(hero, inventory);
                    System.out.println("It's a Potion!");
                } else {
                    item = new Sword(hero, inventory);
                    System.out.println("It's a Sword!");
                }
                // Add the item to inventory
                inventory.addItem(item);
                // Display the current inventory
                inventory.displayItems();
            }
            /* 
            else if (targetTile == 'B') {
                System.out.println("You encountered the boss!");
                Monster monster = new Monster("BOSS",50, 20, 20);
                BattleStatus battlestatus = new BattleStatus(hero, monster,inventory,this);
                battlestatus.displayBattleStatus(); 
            } */
            else if (targetTile == 'E'){
                currentRoom[heroX][heroY] = 'E';
                return;
            }

            currentRoom[heroX][heroY] = '.'; // Clear old position
            heroX = newX;
            heroY = newY;
            currentRoom[heroX][heroY] = 'H'; // Set new position
        }
        else {
            System.out.println("You can't move there!");
        }
        System.out.println("Number of Monster that defeated is " + getNumMonstersDefeated());
        System.out.println("Total number of move and number of action is " + (getNumAction()+getNumMove()));
    }

    public void calculationScore(){
        getNumMove();
        getNumAction();
        getNumMonstersDefeated();
        int difficulty_Monster = difficultyMonster;
        int difficulty_Hero = difficultyHero;
    }
}

