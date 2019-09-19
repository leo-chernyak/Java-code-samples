package L29_Semaphore_Exchanger_Phaser.Task01;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {
    public final String name;
    Semaphore semaphore;

    public Philosopher(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while ( true ) {
            try {
                semaphore.acquire(1);
                System.out.println(name + " got a place at the table");
                Thread.sleep(2500);
                System.out.println(name + " left the table");
                semaphore.release(1);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                semaphore.release(1);
            }
        }
    }
}