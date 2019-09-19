package L29_Semaphore_Exchanger_Phaser.Task01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Задача про обедающих философов. * (решить с использованием семафоров)  * Есть несколько философов, допустим, пять,
 * но одновременно за столом могут сидеть не  * более двух. И надо, чтобы все философы
 * пообедали, но при этом не возникло  * взаимоблокировки философами друг друга  * в борьбе за тарелку и вилку.
 */

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        List<Thread> philosophers = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            philosophers.add(new Thread(new Philosopher("Philosopher " + i, semaphore) ));
        }
        philosophers.forEach(Thread::start);
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        philosophers.forEach(Thread::interrupt);
    }
}