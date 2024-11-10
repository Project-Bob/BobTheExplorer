package projectbob.bobtheexplorer.entity;

public class SpiderLevel1 extends Monster{

    private static final int SPIDER_HP = 30;
    private static final int SPIDER_ATTACKPOWER = 30;
    private static final int SPIDER_SPEED = 20;

    public SpiderLevel1() {
        super( SPIDER_HP, SPIDER_ATTACKPOWER, SPIDER_SPEED);
    }
}
