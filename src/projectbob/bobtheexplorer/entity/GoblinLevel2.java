package projectbob.bobtheexplorer.entity;

public class GoblinLevel2 extends MonsterLevel2{

    private static final String GOBLIN_NAME = "Goblin";
    private static final int GOBLIN_HP = 45;
    private static final int GOBLIN_ATTACKPOWER = 30;
    private static final int GOBLIN_SPEED = 25;

    public GoblinLevel2() {
        super(GOBLIN_NAME, GOBLIN_HP, GOBLIN_ATTACKPOWER, GOBLIN_SPEED);
    }
}
