package projectbob.bobtheexplorer.entity;

public class Potion extends Item{

    public Potion(){
    }

    public void use(){
        hero.setSpeed(hero.getSpeed()+10);
        System.out.println("Potion used. HP increased.");
    }

}

