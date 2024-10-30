    package projectbob.bobtheexplorer.entity;

import java.util.Random;

public class Hero {

        private String name;
        private int HP;
        private int attackPower;
        private int speed;

        public Hero() {
        }

        public Hero(String name, int HP, int attackPower, int speed) {
            this.name = name;
            this.HP = HP;
            this.attackPower = attackPower;
            this.speed = speed;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setHP(int HP) {
            this.HP = HP;
        }
        public int getHP() {
            return HP;
        }

        public void setAttackPower(int attackPower) {
            this.attackPower = attackPower;
        }
        public int getAttackPower() {
            return attackPower;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }
        public int getSpeed() {
            return speed;
        }

        public int attack(){
            System.out.println(name + " attacks with power: " + attackPower);
            return attackPower;
        }

        public int takeDamage(String name,int HP, int damage) {
            int actualdamage = (int)(damage * 0.35);
            HP -= actualdamage;
            if (HP < 0) {
                HP = 0;
            }
            System.out.println(name + " takes damage: " + actualdamage + ". Remaining HP: " + HP);
            return HP;
        }

        public String displayStatus() {
                StringBuilder status = new StringBuilder();
                System.out.println("=============== Hero Status ===============");
                System.out.println(name.toUpperCase() + ": " );
                System.out.println("\tHP: " + HP +"/1000");
                System.out.println("\tAttack Power: " + attackPower + "/1000");
                System.out.println("\tSpeed: " + speed + "/500");
                System.out.println("===========================================");
                return status.toString();
        }

        public void GameOver(int HP){
            if(HP == 0){
                System.out.println("Your HP becomes zero. Game Over!!!");
            }
        }

        public boolean RunAndDodge(int speed) {
            Random random = new Random();
            int RunChance = random.nextInt(10); 

            if (RunChance < speed) {
                System.out.println("Successfully escaped!");
                return true;
            } else {
                System.out.println("Failed to escape. The monster catches up!");
                return false;
            }
    }
}
