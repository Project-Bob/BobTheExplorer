package projectbob.bobtheexplorer.entity;

public class Monster {

    private final int HP;
    private final int ATTACK;
    private final int SPEED;

    public Monster(int HP, int ATTACK, int SPEED){
        this.HP = HP;
        this.ATTACK = ATTACK;
        this.SPEED = SPEED;
    }

    public int getHp() {
        return HP;
    }

    public int getAttack() {
        return ATTACK;
    }

    public int getSpeed() {
        return SPEED;
    }

    public String detailMonster(){
        return "Monster{" + ", hp=" + HP + ", attack=" + ATTACK + ", speed=" + SPEED + '}';
    }
}
