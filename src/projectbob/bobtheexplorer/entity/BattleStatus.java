package projectbob.bobtheexplorer.entity;

import java.util.Scanner;

public class BattleStatus extends Hero{
    
    public BattleStatus(String name, int HP, int attackPower, int speed){
        super(name,HP,attackPower,speed);
    }

    public void displayBattleStatus(String name, int HP, int attackPower, int speed){
        
        Scanner battle = new Scanner(System.in);
        char choice;
        boolean escape = false;

        while(HP > 0){

            System.out.println("=============== Battle Status ===============");
            System.out.println(name.toUpperCase() + ": " );
            System.out.println("\tHP: " + HP +"/1000");
            System.out.println("\tAttack Power: " + attackPower + "/1000");
            System.out.println("\tSpeed: " + speed + "/1000");
            System.out.println("=============================================");
            
            System.out.println("It's your turn. What would you like to do?");
            System.out.println("1.Attack (A)");
            System.out.println("2.Use item (P)");
            System.out.println("3.Run (R)");
            System.out.print("Enter your choice(A/P/R): ");
            choice = battle.next().charAt(0);

            if(choice == 'A'){
                //method of monster having damage
                HP = takeDamage(name, HP, 5); /*should be monster_attack power*/
                
            }
            if(choice == 'B'){
                //Item method will be updated
            }
            if(choice == 'C'){
                escape = RunAndDodge(speed);
            }

            if(escape == true){
                break;
            }
        }
        battle.close();
        
        
    }

}
