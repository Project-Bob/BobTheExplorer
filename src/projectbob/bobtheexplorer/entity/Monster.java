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
