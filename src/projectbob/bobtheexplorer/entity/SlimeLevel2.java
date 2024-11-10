package projectbob.bobtheexplorer.entity;

public class SlimeLevel2 extends MonsterLevel2{

    private static final String SLIME_NAME = "Slime";
    private static final int SLIME_HP = 50;
    private static final int SLIME_ATTACKPOWER = 25;
    private static final int SLIME_SPEED = 25;

    public SlimeLevel2() {
        super(SLIME_NAME,SLIME_HP, SLIME_ATTACKPOWER, SLIME_SPEED);
    }
}
