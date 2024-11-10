package projectbob.bobtheexplorer.entity;

import java.util.Random;
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String character = "";
        int HP = 0;
        int AP = 0;
        int S = 0;
        int SumOfSP = 0;


        while (SumOfSP != 30) {
            System.out.print("Enter name of the hero(Fighter, Marksman, Tank) : ");
            character = scanner.nextLine();
            while (!character.equalsIgnoreCase("Fighter") && !character.equalsIgnoreCase("Marksman") && !character.equalsIgnoreCase("Tank")) {
                System.out.println("Invalid input");
                System.out.print("Enter name of the hero(Fighter, Marksman, Tank) : ");
                character = scanner.nextLine();
            }
            System.out.println("Enter initial ability of character. The initial total ability point should be 30.");
            System.out.print("Enter initial Health Point(HP) : ");
            HP = scanner.nextInt();
            
            System.out.print("Enter initial Attack Power(AP) : ");
            AP = scanner.nextInt();
            
            System.out.print("Enter initial Speed of character(S) : ");
            S = scanner.nextInt();

            SumOfSP = HP + AP + S;
            if (SumOfSP != 30) {
                System.out.println("The initial total status point must be 30 points.");
                System.out.println("Please enter the status of character again.");
            }
        }
        

        switch (character.toLowerCase()) {
            case "fighter" -> {
                Fighter fighter = new Fighter(character, HP, AP, S);
                System.out.println(fighter.displayStatusFighter());
            }
            case "marksman" -> {
                Marksman marksman = new Marksman(character, HP, AP, S);
                System.out.println(marksman.displayStatusMarksman());
            }
            case "tank" -> {
                Tank tank = new Tank(character, HP, AP, S);
                System.out.println(tank.displayStatusTank());
            }
        }
        
        Dungeon dungeon =  new Dungeon();
        
        Scanner map = new Scanner (System.in);
        Random random = new Random();
        int RoomNumber = random.nextInt(5);
        boolean Playing = false;

        Hero hero = new Hero(character, HP, AP, S);
        Monster monster = new Monster("Spider",50, 3, 5);
        Inventory inventory = new Inventory();
        BattleStatus battlestatus = new BattleStatus(hero,monster,inventory);
        battlestatus.displayBattleStatus();

        System.out.println("Welcome to Adventure Quest! Enter play to start the game! ");
        String start = map.nextLine();
        if(start.toUpperCase().equals("PLAY")){
            Playing = true;
        }

        while (Playing) {
            char currentRoom[][] = dungeon.room.get(RoomNumber);
            dungeon.displayDungeon(currentRoom);
            System.out.println("Use W, A, S, D to move.");
            System.out.println("Enter your move (W=up, A=left, S=down, D=right, Q=quit):");
            char move = map.next().toUpperCase().charAt(0);

            switch (move) {
                case 'W' -> dungeon.HeroMove(-1, 0, currentRoom); 
                case 'S' -> dungeon.HeroMove(1, 0, currentRoom); 
                case 'A' -> dungeon.HeroMove(0, -1, currentRoom); 
                case 'D' -> dungeon.HeroMove(0, 1, currentRoom);  
                case 'Q' -> Playing = false;
                default -> System.out.println("Invalid input!");
            }
        }
           map.close();
        scanner.close();

        }
    }

