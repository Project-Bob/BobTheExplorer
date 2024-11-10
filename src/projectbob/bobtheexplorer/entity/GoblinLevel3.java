package projectbob.bobtheexplorer.entity;

public class GoblinLevel3 extends MonsterLevel3{

    private static final String GOBLIN_NAME = "Goblin";
    private static final int GOBLIN_HP = 60;
    private static final int GOBLIN_ATTACKPOWER = 30;
    private static final int GOBLIN_SPEED = 30;

    public GoblinLevel3() {
        super(GOBLIN_NAME,GOBLIN_HP, GOBLIN_ATTACKPOWER, GOBLIN_SPEED);
    }
}
