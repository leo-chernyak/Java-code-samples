package L29_Semaphore_Exchanger_Phaser.Task03;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Время обороняться!
 * На ваш лагерь планируется нападение, через несколько дней. Нужно готовиться к обороне и
 * строить оборонительные сооружения! Для этого потребуются запасы леса. Пришло время
 * отправлять их в лес. Но одновременно в лес может зайти не больше 3 рабочих, иначе их
 * заметят. Получится ли защитить лагерь?
 * Нужно создать класс “лес”, в который могут войти лишь трое рабочих, класс “лагерь”, в
 * котором будут складывать дерево и класс рабочий, который будет заходить в лес и нести
 * оттуда дерево в лагерь. Соответственно, когда рабочий заходить в лес он “засыпает” на
 * случайное значение времени и потом возвращается в лагерь с определенным количеством
 * дерева(каждый раз оно может быть разным). Каждый рабочий может сходить в лес только 5
 * раз, на большее у него не хватит сил. В конце, нужно проверить хватит ли дерева на постройку
 * оборонительных сооружений и понять, переживет ли ваш лагерь нападение.
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        Forest forest = new Forest(200);
        Camp camp = new Camp();
        int countWorkers = 5;
        ArrayList<Worker> workers = new ArrayList<>(countWorkers);
        for (int i = 0; i < countWorkers; i++) {
            Worker worker = new Worker("Worker_" + i, forest, camp, semaphore);
            workers.add(worker);
        }

        workers.forEach(Thread::start);
        for (Worker worker : workers) {
            worker.join();
        }
        System.out.println(camp.trees + " " + forest.trees + " all " + (camp.trees + forest.trees));
    }
}
