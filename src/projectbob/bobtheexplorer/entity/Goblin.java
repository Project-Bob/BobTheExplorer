package projectbob.bobtheexplorer.entity;

public class Goblin extends Monster{

    private static final int GOBLIN_HP = 10;
    private static final int GOBLIN_ATTACKPOWER = 10;
    private static final int GOBLIN_SPEED = 10;

    public Goblin() {
        super(GOBLIN_HP, GOBLIN_ATTACKPOWER, GOBLIN_SPEED);
    }
}
