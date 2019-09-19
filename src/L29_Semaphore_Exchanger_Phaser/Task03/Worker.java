package L29_Semaphore_Exchanger_Phaser.Task03;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Worker extends Thread {
    public final String name;
    int allTrees;
    int counts = 5;
    private Forest forest;
    private Camp camp;
    private Semaphore semaphore;
    public Worker(String name, Forest forest, Camp camp, Semaphore semaphore) {
        this.name = name;
        this.forest = forest;
        this.camp = camp;
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        try {
            while ( counts --> 0 ) {
                semaphore.acquire();
                System.out.println(name + " in the forest.");
                int trees = cutTrees();
                Thread.sleep(new Random().nextInt(1_000));
                System.out.println(name + " out of the forest.");
                semaphore.release();
                transpostTrees(trees);
                Thread.sleep(new Random().nextInt(1_000));
            }
        }
        catch (InterruptedException ignored) {}
    }

    private synchronized int cutTrees() {
        int cutted = 0;
        synchronized (forest) {
            if ( forest.isEmpty() ) return 0;
            cutted = new Random().nextInt(10 );
            if (forest.trees - cutted < 0) cutted = forest.trees;
            forest.trees -= cutted;
        }
        allTrees += cutted;
        return cutted;
    }
    private synchronized void transpostTrees(int trees) {
        camp.trees += trees;
    }
}