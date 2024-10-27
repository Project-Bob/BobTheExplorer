package projectbob.bobtheexplorer.entity;

public class Monster {

    private final int HP;
    private final int ATTACKPOWER;
    private final int SPEED;

    public Monster(int HP, int ATTACKPOWER, int SPEED){
        this.HP = HP;
        this.ATTACKPOWER = ATTACKPOWER;
        this.SPEED = SPEED;
    }

    public int getHp() {
        return HP;
    }

    public int getAttackPower() {
        return ATTACKPOWER;
    }

    public int getSpeed() {
        return SPEED;
    }

    public String detailMonster(){
        return "Monster{" + ", hp=" + HP + ", attack=" + ATTACKPOWER + ", speed=" + SPEED + '}';
    }
}
