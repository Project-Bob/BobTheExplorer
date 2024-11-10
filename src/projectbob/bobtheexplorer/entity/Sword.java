package projectbob.bobtheexplorer.entity;

public class Sword extends Item{

    public Sword(){}

    public void use() {
        if (hero != null) {
            hero.setAttackPower(hero.getAttackPower() + 10);
            System.out.println("Sword used. Hero's speed increased.");
        } else {
            System.out.println("Hero is not initialized properly.");
        }
    }
}
