package projectbob.bobtheexplorer.entity;

public class Slime extends Monster {

    private static final int SLIME_HP = 5;
    private static final int SLIME__ATTACK = 15;
    private static final int SLIME_SPEED = 10;

    public Slime() {
        super(SLIME_HP, SLIME__ATTACK, SLIME_SPEED);
    }
}
