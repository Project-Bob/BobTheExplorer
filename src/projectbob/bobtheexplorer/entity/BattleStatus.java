package projectbob.bobtheexplorer.entity;

import java.util.Scanner;

public class BattleStatus{

    private Hero hero;
    private Monster monster;

    public BattleStatus(Hero hero, Monster monster) {
        this.hero = hero;
        this.monster = monster;
    }

     void displayBattleStatus(){

        Scanner battle = new Scanner(System.in);
        char choice;
        char item;
        boolean escape = false;

        while (hero.getHP() > 0 && monster.getHP() > 0) {
            System.out.println("=============== Battle Status ===============");
            System.out.println(hero.getName().toUpperCase() + ": ");
            System.out.println("\tHP: " + hero.getHP() + "/1000");
            System.out.println("\tAttack Power: " + hero.getAttackPower() + "/1000");
            System.out.println("\tSpeed: " + hero.getSpeed() + "/1000");
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
                if (hero.getSpeed() >= monster.getSpeed()) {
                    System.out.println(hero.getName() + " attacks " + monster.getName() + " for " + hero.getAttackPower() + " damage!");
                    monster.takeDamage(hero.getAttackPower());
                    if (monster.getHP() > 0) {
                        // Monster attacks back
                        System.out.println(monster.getName() + " attacks " + hero.getName() + " for " + monster.getAttackPower() + " damage!");
                        hero.takeDamage(monster.getAttackPower());
                    }
                } else {
                    System.out.println(monster.getName() + " attacks " + hero.getName() + " for " + monster.getAttackPower() + " damage!");
                    hero.takeDamage(monster.getAttackPower());
                    if (hero.getHP() > 0) {
                        System.out.println(hero.getName() + " attacks " + monster.getName() + " for " + hero.getAttackPower() + " damage!");
                        monster.takeDamage(hero.getAttackPower());
                    }
                }
                System.out.println("Updated Battle Status: ");
                System.out.println(hero.getName() + " HP: " + hero.getHP());
                System.out.println(monster.getName() + " HP: " + monster.getHP());
            }
            else if (choice == 'B') {
                System.out.println("Please select item in your inventory");
                System.out.println("1.Sword (S)");
                System.out.println("2.Potion (P)");
                System.out.println("3.Booster (B)");
                System.out.print("Enter your choice(S/P/B): ");
                item = battle.next().charAt(0);

            }
            else if (choice == 'R') {
                escape = hero.Run(hero.getSpeed(), monster.getSpeed());
                if (escape == true) {
                    break;//monster speed);
                }
            }
        }
        if (hero.getHP() <= 0) {
            System.out.println(hero.getName()+ " has been defeated.");
        } else if (monster.getHP() <= 0) {
            System.out.println(monster.getName() + " has been defeated.");
        }
        battle.close();

    }
}
