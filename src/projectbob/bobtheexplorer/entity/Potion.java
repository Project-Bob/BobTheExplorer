package projectbob.bobtheexplorer.entity;

public class Potion extends Item{

    Inventory inventory;

    public Potion(Hero hero, Inventory inventory){
        super(hero);
        this.inventory = inventory;
    }

    public void use() {
        if (hero != null) {
            int currentHP = hero.getHP();
            int maxHP = hero.getMaxHP();
            int newHP = currentHP + 20;
            if(newHP>maxHP){
                newHP = maxHP; //cap HP at maxHP
                System.out.println("Potion used. Hero's HP increased but capped at the maximum (" + maxHP + "). Overflow healing prevented.");
            } else {
                System.out.println("Potion used. Hero's HP increased by 20.");
            }
            hero.setHP(newHP);
            inventory.remove(this);
        } else {
            System.out.println("Hero is not initialized properly.");
        }
    }
}

