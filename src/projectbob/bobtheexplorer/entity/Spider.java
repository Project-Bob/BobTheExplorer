package projectbob.bobtheexplorer.entity;

public class Spider extends Monster{

    private static final int SPIDER_HP = 5;
    private static final int SPIDER_ATTACKPOWER = 10;
    private static final int SPIDER_SPEED = 15;

    public Spider() {
        super(SPIDER_HP, SPIDER_ATTACKPOWER, SPIDER_SPEED);
    }
}
