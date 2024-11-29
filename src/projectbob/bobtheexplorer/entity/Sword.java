package projectbob.bobtheexplorer.entity;

public class Sword extends Item{

    Inventory inventory;

    public Sword(Hero hero, Inventory inventory){
        super(hero);
        this.inventory = inventory;
    }

    public void use() {
        if (hero != null) {
            hero.setAttackPower(hero.getAttackPower() + 5);
            inventory.remove(this);
            System.out.println("Sword used. Hero's speed increased.");
        } else {
            System.out.println("Hero is not initialized properly.");
        }
    }
}

