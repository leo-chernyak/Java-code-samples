package L28_Threads.Task01;

import java.util.Random;

public class Worker implements Runnable {
    Mine mine;
    Random random;
    Castle castle;
    int goldSteel = 0;
    {
        random = new Random();
    }
    public Worker(Mine mine, Castle castle) {
        this.mine = mine;
        this.castle = castle;
    }

    @Override
    public void run() {
        while ( !mine.isEmpty() ) {
            int gold = mine.steelGold();
            goldSteel += gold;
            try { Thread.sleep(random.nextInt(3)); } catch (InterruptedException ignored) {  }
            castle.putGold(gold);
        }
    }
}
