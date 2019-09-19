package L28_Threads.Task01;

public class Mine {
    private int gold = 10_000;
    public synchronized int steelGold() {
        if (isEmpty()) return 0;
        gold -= 500;
        return 500;
    }
    public int getGold() {
        return gold;
    }
    public /*synchronized*/ boolean isEmpty(){ return gold <= 0; }
}