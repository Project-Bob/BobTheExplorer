package projectbob.bobtheexplorer.entity;

public class Tank extends Hero{

    public Tank(String name, int HP, int attackPower, int speed){
        super(name, HP, attackPower, speed);
    }

    public Tank(){
        super();
    }

    public String displayStatusTank() {
        return displayStatus();
    }
}
