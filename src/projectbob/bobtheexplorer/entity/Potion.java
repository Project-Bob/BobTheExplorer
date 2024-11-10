package projectbob.bobtheexplorer.entity;

public class Potion extends Hero{

    public Potion(String name, int HP, int attackPower, int speed){
        super(name, HP+20, attackPower, speed);
    }

    public void pickUpPotion(){}

    public void usePotion(){
        setHP(getHP()+20);
    }

}

