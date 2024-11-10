package projectbob.bobtheexplorer.entity;

public class SlimeLevel1 extends MonsterLevel1 {

    private static final String SLIME_NAME = "Slime";
    private static final int SLIME_HP = 35;
    private static final int SLIME_ATTACKPOWER = 25;
    private static final int SLIME_SPEED = 20;

    public SlimeLevel1() {
        super(SLIME_NAME,SLIME_HP, SLIME_ATTACKPOWER, SLIME_SPEED);
    }
}
