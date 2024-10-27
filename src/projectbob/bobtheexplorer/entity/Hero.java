    package projectbob.bobtheexplorer.entity;

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

        public void takeDamage(int damage) {
            HP -= damage;
            if (HP < 0) {
                HP = 0;
            }
            System.out.println(name + " takes damage: " + damage + ". Remaining HP: " + HP);
        }

        public String displayStatus() {
            return "Hero=" + name + ", HP=" + HP + ", attackPower=" + attackPower + ", speed=" + speed + '}';
        }

    }
