package projectbob.bobtheexplorer.entity;

public class Archer extends Hero{

    public Archer(String name, int HP, int attackPower, int speed){
        super(name, HP, attackPower, speed);
    }

    public String displayStatusArcher() {
        return displayStatus();
    }
}
