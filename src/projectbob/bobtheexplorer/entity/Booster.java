package projectbob.bobtheexplorer.entity;

public class Booster extends Item{

    public Booster(){
    }

    public void use(){
        if (hero != null) {
            hero.setSpeed(hero.getSpeed() + 10);
            System.out.println("Sword used. Hero's speed increased.");
        } else {
            System.out.println("Hero is not initialized properly.");
        }
    }
}

