package projectbob.bobtheexplorer.entity;

public class Booster extends Item{

    public Booster( Hero hero){
        super(hero);
    }

    public void use(){
        hero.setSpeed(hero.getSpeed()+10);
        System.out.println("Booster used. Speed increased.");
    }
}

