package L28_Threads.Task01;

public class Main {
    public static void main(String[] args) throws Exception {
        int count = 0;
        for (int i = 0; i < 100_000; i++) {
            Castle castle = new Castle();
            Mine mine = new Mine();
            Worker worker1 = new Worker(mine, castle);
            Worker worker2 = new Worker(mine, castle);
            Worker worker3 = new Worker(mine, castle);

            Thread thread1 = new Thread(worker1);
            Thread thread2 = new Thread(worker2);
            Thread thread3 = new Thread(worker3);

            thread1.start();
            thread2.start();
            thread3.start();

            thread1.join();
            thread2.join();
            thread3.join();

            int stolen = worker1.goldSteel + worker2.goldSteel + worker3.goldSteel;

            if ( stolen > 10_000 || castle.getGold() != 10_000 || mine.getGold() != 0) {
                String massege = "Parametrs: " + stolen + " " + mine.getGold() + " " + castle.getGold();
                throw new Exception(massege);
            }
        }
        System.out.println("All bad is " + count);
    }
}