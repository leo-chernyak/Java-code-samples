package L28_Threads.Task01;

public class Castle {
    private int golds = 0;

    public synchronized void putGold(int gold) {
        golds += gold;
    }

    public int getGold() {
        return golds;
    }

    public void resetGold() {
        golds = 0;
    }
}