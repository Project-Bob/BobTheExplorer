package projectbob.bobtheexplorer.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

    Hero hero;

    ArrayList<Item> items= new ArrayList<>(){{
        add(new Sword (hero));
        add(new Potion(hero));
    }};


    Scanner scanner = new Scanner(System.in);

    public void addItem(Item item) {
        if (items.size() < 5) {
            items.add(item);
            System.out.println("You are successful add the item into inventory");
        } else {
            System.out.println("Inventory is full. Cannot add more items.");
        }
    }

    public void removeItem(Item item){

        if(items.isEmpty()){
            System.out.println("Inventory is empty. Nothing to remove.");
            return;
        }
        else{
            System.out.println("Select item need to remove");
            System.out.println("1.Sword (S)");
            System.out.println("2.Potion (P)");
            System.out.println("3.Booster (B)");
            System.out.print("Enter your choice(S/P/B): ");
            char equipment = scanner.next().toUpperCase().charAt(0);

            Item itemToRemove = null;

            switch(equipment){
                case 'S':
                    itemToRemove = findItem("Sword");
                    break;
                case 'P':
                    itemToRemove = findItem("Potion");
                    break;
                case 'B':
                    itemToRemove = findItem("Booster");
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
                System.out.println("- " + item);
            }
        }
    }
}
