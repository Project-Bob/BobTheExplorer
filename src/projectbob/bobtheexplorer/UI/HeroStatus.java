package projectbob.bobtheexplorer.UI;

import javafx.scene.control.TextField;

public class HeroStatus {

//    private String Name_Hero;
    private int HP_Hero;
    private int maxHP_Hero;
    private int AP_Hero;
    private int speed_Hero;

    public HeroStatus(int HP_Hero, int AP_Hero, int speed_Hero) {
//        this.Name_Hero = Name_Hero;
        this.HP_Hero = HP_Hero;
        this.maxHP_Hero = HP_Hero;
        this.AP_Hero = AP_Hero;
        this.speed_Hero = speed_Hero;
    }

    public void setHP(int HP) {
        this.HP_Hero = HP;
    }

    public void setAP(int AP_Hero) {
        this.AP_Hero = AP_Hero;
    }

    public void setSpeed(int speed) {
        this.speed_Hero = speed;
    }

//    public String getName() {
//        return Name_Hero;
//    }

    public int getHP_Hero() {
        return HP_Hero;
    }

    public int getMaxHP_Hero() {
        return maxHP_Hero;
    }

    public int getAP_Hero() {
        return AP_Hero;
    }

    public int getSpeed_Hero() {
        return speed_Hero;
    }

    public void takeDamage(int damage) {
        HP_Hero -= damage;
        if (getHP_Hero() < 0) {
            HP_Hero = 0;
        }
    }
}
