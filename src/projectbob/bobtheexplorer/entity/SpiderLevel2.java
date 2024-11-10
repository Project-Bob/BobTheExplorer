package projectbob.bobtheexplorer.entity;

public class SpiderLevel2 extends MonsterLevel2{

    private static final String SPIDER_NAME = "Spider";
    private static final int SPIDER_HP = 40;
    private static final int SPIDER_ATTACKPOWER = 30;
    private static final int SPIDER_SPEED = 30;

    public SpiderLevel2() {
        super(SPIDER_NAME, SPIDER_HP, SPIDER_ATTACKPOWER, SPIDER_SPEED);
    }
}
