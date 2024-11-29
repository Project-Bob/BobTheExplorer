package projectbob.bobtheexplorer.entity;

import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String character;
        int HP=0,AP=0,S=0,difficulty;

        System.out.print("Enter name of the hero(Fighter, Marksman, Archer) : ");
        character = scanner.nextLine();
        while (!character.equalsIgnoreCase("Fighter")
                && !character.equalsIgnoreCase("Marksman")
                && !character.equalsIgnoreCase("Archer")) {
            System.out.println("Invalid input");
            System.out.print("Enter name of the hero(Fighter, Marksman, Archer) : ");
            character = scanner.nextLine();
        }

        switch (character.toLowerCase()) {
            case "fighter" -> {
                do {
                    System.out.print("Enter initial Health Point(HP)(100-150) : ");
                    HP = scanner.nextInt();
                }while(HP<100 || HP>150);

                do {
                    System.out.print("Enter initial Attack Power(AP)(0-20) : ");
                    AP = scanner.nextInt();
                }while(AP<0 || AP>20);

                do {
                    System.out.print("Enter initial Speed of character(S)(10-30) : ");
                    S = scanner.nextInt();
                }while(S<10 || S>30);
                Fighter fighter = new Fighter(character, HP, AP, S);
                System.out.println(fighter.displayStatusFighter());
            }
            case "marksman" -> {
                do {
                    System.out.print("Enter initial Health Point(HP)(100-150) : ");
                    HP = scanner.nextInt();
                }while(HP<100 || HP>150);

                do {
                    System.out.print("Enter initial Attack Power(AP)(10-30) : ");
                    AP = scanner.nextInt();
                }while(AP<10 || AP>30);

                do {
                    System.out.print("Enter initial Speed of character(S)(0-20) : ");
                    S = scanner.nextInt();
                }while(S<0 || S>20);
                Marksman marksman = new Marksman(character, HP, AP, S);
                System.out.println(marksman.displayStatusMarksman());
            }
            case "archer" -> {
                do {
                    System.out.print("Enter initial Health Point(HP)(90-140) : ");
                    HP = scanner.nextInt();
                }while(HP<90 || HP>140);

                do {
                    System.out.print("Enter initial Attack Power(AP)(10-30) : ");
                    AP = scanner.nextInt();
                }while(AP<10 || AP>30);

                do {
                    System.out.print("Enter initial Speed of character(S)(10-30) : ");
                    S = scanner.nextInt();
                }while(S<10 || S>30);
                Archer archer = new Archer(character, HP, AP, S);
                System.out.println(archer.displayStatusArcher());
            }
        }

        do{
            System.out.print("Enter difficulty (1,2,3) : ");
            difficulty = scanner.nextInt();
        }while(difficulty<1 || difficulty>3);

        Hero hero = new Hero(character, HP, AP, S);
        Inventory inventory = new Inventory(hero);

        Game game = new Game(hero, inventory, difficulty);
        System.out.println("\nWelcome to Adventure Quest! Enter 'play' to start the game!");
        scanner.nextLine(); // Clear the buffer
        String start = scanner.nextLine();
        if (start.equalsIgnoreCase("PLAY")) {
            game.startGame();
        } else {
            System.out.println("Goodbye!");
        }
        scanner.close();

    }
}


