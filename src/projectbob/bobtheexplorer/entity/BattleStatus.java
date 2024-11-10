package projectbob.bobtheexplorer.entity;

import java.util.Scanner;

public class BattleStatus extends Hero{
    
    public BattleStatus(String name, int HP, int attackPower, int speed){
        super(name,HP,attackPower,speed);
    }

    public void displayBattleStatus(Monster monster){

        Scanner battle = new Scanner(System.in);
        char choice;
        boolean escape = false;

        while (this.getHP() > 0 && monster.getHP() > 0) {
            System.out.println("=============== Battle Status ===============");
            System.out.println(this.getName().toUpperCase() + ": ");
            System.out.println("\tHP: " + this.getHP() + "/1000");
            System.out.println("\tAttack Power: " + this.getAttackPower() + "/1000");
            System.out.println("\tSpeed: " + this.getSpeed() + "/1000");
            System.out.println("Monster: " + monster.getName());
            System.out.println("\tHP: " + monster.getHP() + "/1000");
            System.out.println("\tAttack Power: " + monster.getAttackPower() + "/1000");
            System.out.println("\tSpeed: " + monster.getSpeed() + "/1000");
            System.out.println("=============================================");


            System.out.println("It's your turn. What would you like to do?");
            System.out.println("1.Attack (A)");
            System.out.println("2.Use item (P)");
            System.out.println("3.Run (R)");
            System.out.print("Enter your choice(A/P/R): ");
            choice = battle.next().charAt(0);

            if (choice == 'A' || choice == 'a') {
                if( this.getSpeed() >= monster.getSpeed()) {
                    System.out.println(this.getName() + " attacks " + monster.getName() + " for " + this.getAttackPower() + " damage!");
                    monster.takeDamage(this.getAttackPower());
                    if (monster.getHP() > 0) {
                        // Monster attacks back
                        System.out.println(monster.getName() + " attacks " + this.getName() + " for " + monster.getAttackPower() + " damage!");
                        this.takeDamage(monster.getAttackPower());
                    }
                }
                else{
                    System.out.println(monster.getName() + " attacks " + this.getName() + " for " + monster.getAttackPower() + " damage!");
                    this.takeDamage(monster.getAttackPower());
                    if (this.getHP() > 0) {
                        System.out.println(this.getName() + " attacks " + monster.getName() + " for " + this.getAttackPower() + " damage!");
                        monster.takeDamage(this.getAttackPower());
                    }
                }
                if (choice == 'B') {
                    //Item method will be updated
                }
                if (choice == 'C') {
                    escape = Run(this.getSpeed(), monster.getSpeed()); //monster speed);
                }

                if (escape == true) {
                    break;
                }
                System.out.println("Updated Battle Status: ");
                System.out.println(this.getName() + " HP: " + this.getHP());
                System.out.println(monster.getName() + " HP: " + monster.getHP());
            }
        }
        if (this.getHP() <= 0) {
            System.out.println(this.getName()+ " has been defeated.");
        } else if (monster.getHP() <= 0) {
            System.out.println(monster.getName() + " has been defeated.");
        }
        battle.close();

    }
}
