package projectbob.bobtheexplorer.Character;

import java.util.*;
public class Character {
    
    static void Character_1(){
        
        int SumOfSP = 0;
        Scanner scanner = new Scanner(System.in);

            while(SumOfSP<10||SumOfSP>10){
                System.out.println("Enter initial ability of character. The initial total ability point should be 10.");
                System.out.print("Enter name of the hero : ");
                String character_1 = scanner.nextLine();
                System.out.print("Enter initial Health Point(HP) : ");
                int HP = scanner.nextInt();
                System.out.print("Enter initial Attack Power(AP) : ");
                int AP = scanner.nextInt();
                System.out.print("Enter initial Speed of character(S) : ");
                int S = scanner.nextInt();
                scanner.nextLine();

                SumOfSP = HP + AP + S;
                if(SumOfSP<10||SumOfSP>10){
                    System.out.println("The initial total status point must be 10 points.");
                    System.out.println("Please enter the status of character again.");
                }
            }
        }
        
    static void Character_2(){

        int SumOfSP = 0;
        Scanner scanner = new Scanner(System.in);

            while(SumOfSP<10||SumOfSP>10){
                System.out.println("Enter initial ability of character. The initial total ability point should be 10.");
                System.out.print("Enter name of the hero : ");
                String character_2 = scanner.nextLine();
                System.out.print("Enter initial Health Point(HP) : ");
                int HP = scanner.nextInt();
                System.out.print("Enter initial Attack Power(AP) : ");
                int AP = scanner.nextInt();
                System.out.print("Enter initial Speed of character(S) : ");
                int S = scanner.nextInt();
                scanner.nextLine();

                SumOfSP = HP + AP + S;
                if(SumOfSP<10||SumOfSP>10){
                    System.out.println("The initial total status point must be 10 points.");
                    System.out.println("Please enter the status of character again.");
                }
            }
        }

    static void Character_3(){

        int SumOfSP = 0;
        Scanner scanner = new Scanner(System.in);

            while(SumOfSP<10||SumOfSP>10){
                System.out.println("Enter initial ability of character. The initial total ability point should be 10.");
                System.out.print("Enter name of the hero : ");
                String character_3 = scanner.nextLine();
                System.out.print("Enter initial Health Point(HP) : ");
                int HP = scanner.nextInt();
                System.out.print("Enter initial Attack Power(AP) : ");
                int AP = scanner.nextInt();
                System.out.print("Enter initial Speed of character(S) : ");
                int S = scanner.nextInt();
                scanner.nextLine();

                SumOfSP = HP + AP + S;
                if(SumOfSP<10||SumOfSP>10){
                    System.out.println("The initial total status point must be 10 points.");
                    System.out.println("Please enter the status of character again.");
                }
            }
        }

    }


