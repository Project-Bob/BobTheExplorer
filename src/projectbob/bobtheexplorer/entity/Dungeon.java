package projectbob.bobtheexplorer.entity;

import java.util.ArrayList;

public class Dungeon {

    private Hero hero;
    private Monster monster;
    private Inventory inventory;

    public Dungeon(Hero hero, Monster monster, Inventory inventory) {
        this.hero = hero;
        this.monster = monster;
        this.inventory = inventory;
    }

    final int Dungeon_size = 10;
    int heroX = 4; 
    int heroY = 3;
    ArrayList<char[][]> room = new ArrayList<char[][]>();

    public Dungeon(){

        char[][] room1 = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', 'M', '.', '.', '.', '.', 'M', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', 'H', '.', '.', '.', '.', 'B', 'E'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', 'I', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', 'M', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        };

        char[][] room2 = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '.', '.', '.', 'M', '.', '.', '.', '.', '#'},
            {'#', 'M', '.', '.', '.', '.', '.', 'M', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', 'H', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', 'B', 'E'},
            {'#', '.', 'I', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', 'M', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        };

        char[][] room3 = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', 'M', '.', '.', '.', '.', 'M', '.', 'M', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', 'H', 'M', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', 'B', 'E'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', 'I', '.', '.', 'M', '.', '.', '.', '.', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        };

        char[][] room4 = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', 'H', '.', '.', '.', 'M', 'M', '#'},
            {'#', '.', '.', '.', '.', '.', '.', 'M', 'B', 'E'},
            {'#', '.', '.', '.', '.', '.', '.', 'M', 'M', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        };

        char[][] room5 = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', 'M', '.', '.', 'I', '.', '.', '#'},
            {'#', '.', 'M', 'H', 'M', '.', '.', '.', '.', '#'},
            {'#', '.', '.', 'M', '.', '.', '.', '.', 'B', 'E'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        };

            room.add(room1);
            room.add(room2);
            room.add(room3);
            room.add(room4);
            room.add(room5);

        }   

    //display the map 
    public void displayDungeon(char[][]room) {
        System.out.println("===================");
        for (char[] row : room) {
            for (char tile : row) {
                System.out.print(tile + " ");
            }
            System.out.println();
        }
        System.out.println("===================");
    }

    //controller for hero to move
    public void HeroMove(int dx, int dy, char currentRoom[][]) {


        Monster monster = new Monster("Spider",50, 3, 5);
        BattleStatus battlestatus = new BattleStatus(hero, monster,inventory);

        int newX = heroX + dx;
        int newY = heroY + dy;

        //change the position of hero and if encounter the wall,display can't move message
        if (newX >= 0 && newX < Dungeon_size && newY >= 0 && newY < Dungeon_size && currentRoom[newX][newY] != '#') {
            char targetTile = currentRoom[newX][newY];
            if (targetTile == 'M') {
                System.out.print("You encounter a monster!");
                battlestatus.displayBattleStatus();
            } 
            else if (targetTile == 'I') {
                System.out.println("You found an item!");
                //Item random logic is required
            } 
            else if (targetTile == 'B') {
                System.out.println("You encountered the boss!");
                battlestatus.displayBattleStatus();
            } 
            else if (targetTile == 'E') {
                System.out.println("You have entered the next room"); 
                //logic on nextroom 
            }

            currentRoom[heroX][heroY] = '.'; // Clear old position
            heroX = newX;
            heroY = newY;
            currentRoom[heroX][heroY] = 'H'; // Set new position
        } 
        else {
            System.out.println("You can't move there!");
        }
    }



        
 






}



