package projectbob.bobtheexplorer.entity;

public class Booster extends Hero {

    public Booster(String name, int HP, int attackPower, int speed){
        super(name, HP, attackPower, speed);
    }

    public void pickUpBooster(){}

    public void useBooster(){
        setSpeed(getSpeed()+10);
    }
}

