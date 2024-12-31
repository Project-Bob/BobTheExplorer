package projectbob.bobtheexplorer.entity;

public class Monster {

    private final String Name;
    private int HP;
    private final int maxHP;
    private final int ATTACKPOWER;
    private final int SPEED;

    public Monster( String Name,int HP, int ATTACKPOWER, int SPEED){
        this.Name = Name;
        this.HP = HP;
        this.maxHP = HP;
        this.ATTACKPOWER = ATTACKPOWER;
        this.SPEED = SPEED;
    }

    public String getName(){ return Name; }

    public int getHP() {
        return HP;
    }

    public int getMaxHP(){
        return maxHP;
    }

    public int getAttackPower() {
        return ATTACKPOWER;
    }

    public int getSpeed() {
        return SPEED;
    }

    public void takeDamage(int damage) {
        HP -= damage;
        if (HP < 0) {
            HP = 0;
        }
    }

    public String detailMonster(){
        StringBuilder status = new StringBuilder();
        System.out.println("=============== Monster Status ===============");
        System.out.println("Monster: " + getName());
        System.out.println("\tHP: " + HP + "/" + getMaxHP());
        System.out.println("\tAttack Power: " + ATTACKPOWER + "/" + ATTACKPOWER);
        System.out.println("\tSpeed: " + SPEED + "/" + SPEED);
        System.out.println("==============================================");
        return status.toString();
    }
}

