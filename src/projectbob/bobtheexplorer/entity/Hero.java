    package projectbob.bobtheexplorer.entity;

    public class Hero {

        private int hp;
        private int attack;
        private int speed;

        public Hero() {
        }

        public Hero(int hp, int attack, int speed) {
            setHp(hp);
            setAttack(attack);
            setSpeed(speed);
        }

        public void setHp(int hp) {
            this.hp = hp;
        }
        public int getHp() {
            return hp;
        }

        public void setAttack(int attack) {
            this.attack = attack;
        }
        public int getAttack() {
            return attack;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }
        public int getSpeed() {
            return speed;
        }

        public String detailHero() {
            return "Hero{" + "hp=" + hp + ", attack=" + attack + ", speed=" + speed + '}';
        }

    }
