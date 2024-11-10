package projectbob.bobtheexplorer.entity;

public class Sword extends Item{

    public Sword( Hero hero){
        super(hero);
    }

    public void use(){
        hero.setSpeed(hero.getSpeed()+10);
        System.out.println("Sword used. Attack power increased.");
    }
}
