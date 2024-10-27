package projectbob.bobtheexplorer.entity;

public class Marksman extends Hero{

    public Marksman (String name, int HP, int attackPower, int speed) {
        super(name, HP, attackPower, speed);
    }

    public Marksman() {
        super();
    }

    public String displayStatusMarksman() {
        return displayStatus();
    }
}

