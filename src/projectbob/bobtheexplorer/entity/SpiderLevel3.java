package projectbob.bobtheexplorer.entity;

public class SpiderLevel3 extends MonsterLevel3{

    private static final String SPIDER_NAME = "Spider";
    private static final int SPIDER_HP = 40;
    private static final int SPIDER_ATTACKPOWER = 40;
    private static final int SPIDER_SPEED = 40;

    public SpiderLevel3() {
        super(SPIDER_NAME,SPIDER_HP, SPIDER_ATTACKPOWER, SPIDER_SPEED);
    }
}
