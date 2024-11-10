    package projectbob.bobtheexplorer.entity;

import java.util.Random;

public class Hero {

        private String name;
        private int HP;
        private int attackPower;
        private int speed;

        public Hero(){}

        public Hero(String name, int HP, int attackPower, int speed) {
            this.name = name;
            this.HP = HP;
            this.attackPower = attackPower;
            this.speed = speed;
        }

        Hero(){
        }

        public String getName() {
            return name;
        }

        public int getHP() {
            return HP;
        }

        public int getAttackPower() {
            return attackPower;
        }

        public int getSpeed() {
            return speed;
        }

        public int takeDamage(int damage) {
                HP -= damage;
                if (HP < 0) {
                    HP = 0;
                }
                System.out.println(name + " takes damage: " + damage + ". Remaining HP: " + HP);
                return HP;
        }

        public String displayStatus() {
                StringBuilder status = new StringBuilder();
                System.out.println("=============== Hero Status ===============");
                System.out.println(name.toUpperCase() + ": " );
                System.out.println("\tHP: " + HP +"/1000");
                System.out.println("\tAttack Power: " + attackPower + "/1000");
                System.out.println("\tSpeed: " + speed + "/1000");
                System.out.println("===========================================");
                return status.toString();
        }

        public void GameOver(int HP){
            if(HP == 0){
                System.out.println("Your HP becomes zero. Game Over!!!");
            }
        }

        public boolean Dodge(int speed) {
            Random random = new Random();
            int runChance = random.nextInt(100);  
            int successThreshold = Math.min(speed / 100, 75);  
        
            if (runChance < successThreshold) {
                System.out.println("Successfully escaped!");
                return true;
            } else {
                System.out.println("Failed to escape. The monster catches up!");
                return false;
            }
        }

        public boolean Run(int HeroSpeed, int MonsterSpeed){
            if(HeroSpeed>MonsterSpeed){
                return true;
            }
            else{
                return false;
            }
        }

}

