package projectbob.bobtheexplorer.entity;

public class BattleStatus extends Hero{
    
    public BattleStatus(String name, int HP, int attackPower, int speed){
        super(name,HP,attackPower,speed);
    }

    public void displayBattleStatus(String name, int HP, int attackPower, int speed){
        
        System.out.println("=============== Battle Status ===============");
        System.out.println(name.toUpperCase() + ": " );
        System.out.println("\tHP: " + HP +"/1000");
        System.out.println("\tAttack Power: " + attackPower + "/1000");
        System.out.println("\tSpeed: " + speed + "/500");
        System.out.println("=============================================");
        
    }

}
