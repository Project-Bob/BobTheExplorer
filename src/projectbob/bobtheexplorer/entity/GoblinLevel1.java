package projectbob.bobtheexplorer.entity;

public class GoblinLevel1 extends MonsterLevel1{

    private static final int GOBLIN_HP = 40;
    private static final int GOBLIN_ATTACKPOWER = 20;
    private static final int GOBLIN_SPEED = 20;

    public GoblinLevel1() {
        super(GOBLIN_HP, GOBLIN_ATTACKPOWER, GOBLIN_SPEED);
    }
}
