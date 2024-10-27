package projectbob.bobtheexplorer.entity;

import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {

        int SumOfSP = 0;
        Scanner scanner = new Scanner(System.in);
        String character = "";
        int HP = 0;
        int AP = 0;
        int S = 0;

        while(SumOfSP != 10){
            System.out.print("Enter name of the hero(Fighter, Marksman, Tank) : ");
            character = scanner.nextLine();
            while( !character.equalsIgnoreCase("Fighter") && !character.equalsIgnoreCase("Marksman") && !character.equalsIgnoreCase("Tank")){
                System.out.println("Invalid input");
                System.out.print("Enter name of the hero(Fighter, Marksman, Tank) : ");
                character = scanner.nextLine();
            }
            System.out.println("Enter initial ability of character. The initial total ability point should be 10.");
            System.out.print("Enter initial Health Point(HP) : ");
            HP = scanner.nextInt();
            System.out.print("Enter initial Attack Power(AP) : ");
            AP = scanner.nextInt();
            System.out.print("Enter initial Speed of character(S) : ");
            S = scanner.nextInt();
            scanner.nextLine();

            SumOfSP = HP + AP + S;
            if(SumOfSP != 10){
                System.out.println("The initial total status point must be 10 points.");
                System.out.println("Please enter the status of character again.");
            }
        }
        scanner.close();

        switch (character) {
            case "Fighter" -> {
                Fighter fighter = new Fighter(HP, AP, S);
                System.out.println(fighter.detailHero());
            }
            case "Marksman" -> {
                Marksman marksman = new Marksman(HP, AP, S);
                System.out.println(marksman.detailHero());
            }
            case "Tank" -> {
                Tank tank = new Tank(HP, AP, S);
                System.out.println(tank.detailHero());
            }
        }

    }
}
