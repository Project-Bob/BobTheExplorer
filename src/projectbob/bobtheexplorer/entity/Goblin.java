package projectbob.bobtheexplorer.entity;

public class Goblin extends Monster{

    private static final int GOBLIN_HP = 10;
    private static final int GOBLIN_ATTACK = 10;
    private static final int GOBLIN_SPEED = 10;

    public Goblin() {
        super(GOBLIN_HP, GOBLIN_ATTACK, GOBLIN_SPEED);
    }
}
