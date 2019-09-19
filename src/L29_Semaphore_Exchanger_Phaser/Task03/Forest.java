package L29_Semaphore_Exchanger_Phaser.Task03;

public class Forest {
    int trees;
    public Forest( int trees) {
        this.trees = trees;
    }
    public synchronized boolean isEmpty() { return trees <= 0; }
}
