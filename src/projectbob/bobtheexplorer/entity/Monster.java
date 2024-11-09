package projectbob.bobtheexplorer.entity;

public class Monster {

    private String Name;
    private  int HP;
    private final int ATTACKPOWER;
    private final int SPEED;

    public Monster( int HP, int ATTACKPOWER, int SPEED){
        this.HP = HP;
        this.ATTACKPOWER = ATTACKPOWER;
        this.SPEED = SPEED;
    }

    public String getName(){ return Name; }

    public int getHP() {
        return HP;
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
                //System.out.println(Monster.toUpperCase() + ": " ); 
                /*
                 Probably monster status will be insert in every monster class since the name is different
                 unless the name can be variable. 
                 */
                System.out.println("\tHP: " + HP +"/1000");
                System.out.println("\tAttack Power: " + ATTACKPOWER + "/1000");
                System.out.println("\tSpeed: " + SPEED + "/500");
                System.out.println("==============================================");
                return status.toString();
    }
}
