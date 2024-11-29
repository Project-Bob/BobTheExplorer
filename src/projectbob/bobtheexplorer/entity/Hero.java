    package projectbob.bobtheexplorer.entity;

    import java.util.Random;

    public class Hero {

        private final String name;
        private int HP;
        private final int maxHP;
        private int attackPower;
        private int speed;

        public Hero(String name, int HP, int attackPower, int speed) {
            this.name = name;
            this.HP = HP;
            this.maxHP = HP;
            this.attackPower = attackPower;
            this.speed = speed;
        }

        public void setHP(int HP) {
            this.HP = HP;
        }

        public void setAttackPower(int attackPower) {
            this.attackPower = attackPower;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public String getName() {
            return name;
        }

        public int getHP() {
            return HP;
        }

        public int getMaxHP() {
            return maxHP;
        }

        public int getAttackPower() {
            return attackPower;
        }

        public int getSpeed() {
            return speed;
        }

        public void takeDamage(int damage) {
            HP -= damage;
            if (HP < 0) {
                HP = 0;
            }
            System.out.println(name + " takes damage: " + damage + ". Remaining HP: " + HP);
        }

        public String displayStatus() {
            StringBuilder status = new StringBuilder();
            System.out.println("\n=============== Hero Status ===============");
            System.out.println(name.toUpperCase() + ": " );
            System.out.println("\tHP: " + HP + "/" + getMaxHP());
            System.out.println("\tAttack Power: " + attackPower + "/" + attackPower);
            System.out.println("\tSpeed: " + speed + "/" + speed);
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
            return HeroSpeed > MonsterSpeed;
        }
    }
