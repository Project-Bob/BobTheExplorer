package projectbob.bobtheexplorer.entity;

public class Fighter extends Hero{

    public Fighter(String name, int HP, int attackPower, int speed) {
        super(name, HP, attackPower, speed);
    }

    public String displayStatusFighter() {
        return displayStatus();
    }
}