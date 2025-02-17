package projectbob.bobtheexplorer.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

    Hero hero;

    private final ArrayList<Item> items;

    public Inventory(Hero hero){
        items = new ArrayList<>();
        this.hero = hero;
        //Before starting the game player already got one potion and one sword
        items.add(new Sword(hero,this));
        items.add(new Potion(hero,this));
    }


    Scanner scanner = new Scanner(System.in);

    public void addItem(Item item) {

        int choice;
        if (items.size() < 50) {
            items.add(item);
            System.out.println("Added " + item.getClass().getSimpleName() + " to inventory.");
        } else {
            do {
                System.out.println("Inventory is full.");
                System.out.println("1. Replace an existing item");
                System.out.println("2. Keep current inventory");
                choice = scanner.nextInt();
            }while(choice != 1 && choice != 2);
            if (choice == 1) {
                removeItem(item);
                items.add(item);
                System.out.println("Replaced an item with " + item.getClass().getSimpleName() + ".");
            } else {
                System.out.println("Kept current inventory.");
            }
        }
    }

    //user choose to remove item
    public void removeItem(Item item){

        if(items.isEmpty()){
            System.out.println("Inventory is empty. Nothing to remove.");
            return;
        }
        else{
            System.out.println("Select item need to remove");
            System.out.println("1.Sword (S)");
            System.out.println("2.Potion (P)");
            System.out.print("Enter your choice(S/P): ");
            char equipment = scanner.next().toUpperCase().charAt(0);

            Item itemToRemove = null;

            switch(equipment){
                case 'S':
                    itemToRemove = findItem("Sword");
                    break;
                case 'P':
                    itemToRemove = findItem("Potion");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid item.");
                    return;
            }
            if (itemToRemove != null) {
                items.remove(itemToRemove);
                System.out.println("You have successfully removed the item from the inventory.");
            } else {
                System.out.println("The item you selected is not in your inventory.");
            }
        }
    }

    //to remove the item after hero use
    public void remove(Item item) {
        items.remove(item);
    }

    public Item findItem(String itemName) {
        for (Item item : items) {
            if (item.getClass().getSimpleName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;  // Item not found
    }

    public ArrayList<Item> getItems() {
        return new ArrayList<>(items);
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Items in inventory:");
            for (Item item : items) {
                System.out.println("- " + item.getClass().getSimpleName());
            }
        }
    }
}
