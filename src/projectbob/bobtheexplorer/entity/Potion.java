package projectbob.bobtheexplorer.entity;

public class Potion extends Item{

    public Potion(){
    }

    public void use() {
        if (hero != null) {
            hero.setHP(hero.getHP() + 20);
            System.out.println("Sword used. Hero's speed increased.");
        } else {
            System.out.println("Hero is not initialized properly.");
        }
    }
}

