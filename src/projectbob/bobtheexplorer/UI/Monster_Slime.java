package projectbob.bobtheexplorer.UI;

import java.util.Random;

public class Monster_Slime {
    private String name;
    private int hp;
    private int ap;
    private int speed;

    public static Monster_Slime createSlime(String difficulty){
        Random r = new Random();
        int HP_Slime=0, AP_Slime=0, Speed_Slime=0;
        if(difficulty.equals("Level 1")){
            HP_Slime = r.nextInt(20,35);
            AP_Slime = r.nextInt(5,9);
            Speed_Slime = r.nextInt(8,12);
        }
        else if(difficulty.equals("Level 2")){
            HP_Slime = r.nextInt(40,61);
            AP_Slime = r.nextInt(10,14);
            Speed_Slime = r.nextInt(15,18);
        }
        else if(difficulty.equals("Level 3")){
            HP_Slime = r.nextInt(60,80);
            AP_Slime = r.nextInt(15, 25);
            Speed_Slime = r.nextInt(18,25);
        }
        return new Monster_Slime(HP_Slime, AP_Slime, Speed_Slime);
    }

    public Monster_Slime(int hp, int ap, int speed) {
        this.hp = hp;
        this.ap = ap;
        this.speed = speed;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap){
        this.ap = ap;
    }

    public int getSpeed() {
        return speed;
    }

    public void takeDamage(int damage) {
        this.hp = Math.max(0, this.hp - damage);
    }

}