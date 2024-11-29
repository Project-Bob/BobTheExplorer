package projectbob.bobtheexplorer.entity;

import java.util.Scanner;

public class BattleStatus {

    private final Hero hero;
    private final Monster monster;
    private final Inventory inventory;

    public BattleStatus(Hero hero, Monster monster, Inventory inventory) {
        this.hero = hero;
        this.monster = monster;
        this.inventory = inventory;
    }

    void displayBattleStatus() {
        Scanner scanner = new Scanner(System.in);

        while (hero.getHP() > 0 && monster.getHP() > 0) {
            displayStatus();

            System.out.println("It's your turn. What would you like to do?");
            System.out.println("1. Attack (A)");
            System.out.println("2. Use item (U)");
            System.out.println("3. Run (R)");
            System.out.print("Enter your choice (A/U/R): ");
            char choice = scanner.next().toUpperCase().charAt(0);

            switch (choice) {
                case 'A':
                    performAttack();
                    break;
                case 'U':
                    useItem(scanner);
                    inventory.displayItems();
                    break;
                case 'R':
                    if (attemptEscape()) {
                        return; // Exit battle if escape is successful
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option (A/U/R).");
                    break;
            }

            // Check if anyone is defeated after the turn
            if (hero.getHP() <= 0) {
                System.out.println(hero.getName() + " has been defeated.");
                break;
            } else if (monster.getHP() <= 0) {
                System.out.println(monster.getName() + " has been defeated.");
                break;
            }
        }
    }

    // Method to display current battle status
    private void displayStatus() {
        System.out.println("\n=============== Battle Status ===============");
        System.out.println(hero.getName().toUpperCase() + ": ");
        System.out.println("\tHP: " + hero.getHP() + "/" + hero.getMaxHP());
        System.out.println("\tAttack Power: " + hero.getAttackPower() + "/" + hero.getAttackPower());
        System.out.println("\tSpeed: " + hero.getSpeed() + "/" + hero.getSpeed());
        System.out.println(monster.getName().toUpperCase() + ": ");
        System.out.println("\tHP: " + monster.getHP() + "/" + monster.getMaxHP());
        System.out.println("\tAttack Power: " + monster.getAttackPower() + "/" + monster.getAttackPower());
        System.out.println("\tSpeed: " + monster.getSpeed() + "/1" + monster.getSpeed());
        System.out.println("=============================================");
    }

    // Method to handle attack action
    private void performAttack() {
        if (hero.getSpeed() >= monster.getSpeed()) {
            System.out.println(hero.getName() + " attacks " + monster.getName() + " for " + hero.getAttackPower() + " damage!");
            monster.takeDamage(hero.getAttackPower());
            if (monster.getHP() > 0) {
                monsterAttacksBack();
            }
        } else {
            monsterAttacksBack();
            if (hero.getHP() > 0) {
                System.out.println(hero.getName() + " attacks " + monster.getName() + " for " + hero.getAttackPower() + " damage!");
                monster.takeDamage(hero.getAttackPower());
            }
        }
        printUpdatedBattleStatus();
    }

    // Monster attacks back after the hero's turn
    private void monsterAttacksBack() {
        System.out.println(monster.getName() + " attacks " + hero.getName() + " for " + monster.getAttackPower() + " damage!");
        hero.takeDamage(monster.getAttackPower());
    }

    // Print the updated battle status after each action
    private void printUpdatedBattleStatus() {
        System.out.println("Updated Battle Status: ");
        System.out.println(hero.getName() + " HP: " + hero.getHP());
        System.out.println(monster.getName() + " HP: " + monster.getHP());
    }

    // Method to handle item usage action
    private void useItem(Scanner scanner) {
        System.out.println("\nPlease select an item in your inventory");
        System.out.println("1. Sword (S)");
        System.out.println("2. Potion (P)");
        System.out.print("Enter your choice (S/P): ");
        char equipment = scanner.next().toUpperCase().charAt(0);

        Item itemToUse;

        switch (equipment) {
            case 'S':
                itemToUse = inventory.findItem("Sword");
                break;
            case 'P':
                itemToUse = inventory.findItem("Potion");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid item.");
                return;
        }

        if (itemToUse == null) {
            System.out.println(equipment == 'S' ? "Sword" + " not found in inventory." : "Potion" + " not found in inventory.");
            return;
        }

        if (itemToUse instanceof Sword sword) {
            sword.use();
        } else if (itemToUse instanceof Potion potion) {
            potion.use();
        }
    }

    // Method to handle run (escape) action
    private boolean attemptEscape() {
        boolean escape = hero.Run(hero.getSpeed(), monster.getSpeed());
        if (escape) {
            System.out.println(hero.getName() + " successfully escaped from the battle.");
        } else {
            System.out.println(hero.getName() + " failed to escape.");
        }
        return escape;
    }
}

