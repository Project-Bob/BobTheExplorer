package projectbob.bobtheexplorer.entity;

public class Sword extends Hero {

    public Sword(String name, int HP, int attackPower, int speed){
        super(name, HP, attackPower, speed);
    }

    public pickUpSword(){

    }

    public void useSword(){
        setAttackPower(getAttackPower()+10);
    }
}
