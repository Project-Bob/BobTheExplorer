package projectbob.bobtheexplorer.Hero;

import java.util.*;
public class Hero {
    
    static void Hero_1(){
        
        int SumOfSP = 0;
        Scanner scanner = new Scanner(System.in);

            while(SumOfSP<10||SumOfSP>10){
                System.out.println("Enter initial ability of character. The initial total ability point should be 10.");
                System.out.print("Enter name of the hero : ");
                String hero_1 = scanner.nextLine();
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
        scanner.close();
        }
        
    static void Hero_2(){

        int SumOfSP = 0;
        Scanner scanner = new Scanner(System.in);

            while(SumOfSP<10||SumOfSP>10){
                System.out.println("Enter initial ability of character. The initial total ability point should be 10.");
                System.out.print("Enter name of the hero : ");
                String hero_2 = scanner.nextLine();
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
        scanner.close();
        }

    static void Hero_3(){

        int SumOfSP = 0;
        Scanner scanner = new Scanner(System.in);

            while(SumOfSP<10||SumOfSP>10){
                System.out.println("Enter initial ability of character. The initial total ability point should be 10.");
                System.out.print("Enter name of the hero : ");
                String hero_3 = scanner.nextLine();
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
        scanner.close();
        }

    }


