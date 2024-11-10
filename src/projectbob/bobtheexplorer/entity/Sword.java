package projectbob.bobtheexplorer.entity;

public class Sword extends Hero {

    public Sword(String name, int HP, int attackPower, int speed){
        super(name, HP, attackPower+10, speed);

    }
}
