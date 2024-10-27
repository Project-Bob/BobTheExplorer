package projectbob.bobtheexplorer.entity;

public class Slime extends Monster {

    private static final int SLIME_HP = 5;
    private static final int SLIME_ATTACKPOWER = 15;
    private static final int SLIME_SPEED = 10;

    public Slime() {
        super(SLIME_HP, SLIME_ATTACKPOWER, SLIME_SPEED);
    }
}
