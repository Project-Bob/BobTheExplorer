package projectbob.bobtheexplorer.entity;

import java.util.Scanner;

public class BattleStatus{

    private final Hero hero;
    private final Monster monster;
    private final Inventory inventory;

    public BattleStatus(Hero hero, Monster monster, Inventory inventory) {
        this.hero = hero;
        this.monster = monster;
        this.inventory = inventory;
    }

     void displayBattleStatus(){

        Scanner battle = new Scanner(System.in);
        char choice;
        char equipment;
        boolean escape ;

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
            System.out.println("2.Use item (U)");
            System.out.println("3.Run (R)");
            System.out.print("Enter your choice(A/U/R): ");
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
            else if (choice == 'U') {

                System.out.println("Please select item in your inventory");
                System.out.println("1.Sword (S)");
                System.out.println("2.Potion (P)");
                System.out.print("Enter your choice(S/P): ");
                equipment = battle.next().toUpperCase().charAt(0);

                Item itemToUse;

                switch(equipment){
                    case 'S':
                        itemToUse = inventory.findItem("Sword");
                        if(itemToUse instanceof Sword sword){
                            sword.use();
                        }
                        break;
                    case 'P':
                        itemToUse = inventory.findItem("Potion");
                        if(itemToUse instanceof Potion potion){
                            potion.use();
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid item.");
                        return;
                }

            }
            else if (choice == 'R') {
                escape = hero.Run(hero.getSpeed(), monster.getSpeed());
                if (escape) {
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
