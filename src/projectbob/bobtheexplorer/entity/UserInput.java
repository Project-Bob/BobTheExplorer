package projectbob.bobtheexplorer.entity;

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
            scanner.nextLine();

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

        BattleStatus battlestatus = new BattleStatus(character, HP, SumOfSP, S);
        battlestatus.displayBattleStatus(character, HP, SumOfSP, S);

         

        scanner.close();
        }
    }

