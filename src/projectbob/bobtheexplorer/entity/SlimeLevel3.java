package projectbob.bobtheexplorer.entity;

public class SlimeLevel3 extends MonsterLevel3{

    private static final String SLIME_NAME = "Slime";
    private static final int SLIME_HP = 50;
    private static final int SLIME_ATTACKPOWER = 35;
    private static final int SLIME_SPEED = 35;

    public SlimeLevel3() {
        super(SLIME_NAME, SLIME_HP, SLIME_ATTACKPOWER, SLIME_SPEED);
    }
}
