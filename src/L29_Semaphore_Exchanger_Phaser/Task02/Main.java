package L29_Semaphore_Exchanger_Phaser.Task02;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Соревнование бардов.
 * Четверо бардов пришли в таверну. У каждого из них есть своя песня. В середине вечера, хозяин
 * заведения попросил их исполнить песню. Прилично выпив, барды не смогли прийти к
 * согласию кто именно будет петь и решили составить общую песню на основе остальных. Было
 * решено, что хозяин этого захудалого местечка, получит максимум 8 слов. Барды придумали
 * способ, как составить текст, да так, чтобы каждый поучаствовал. А именно:
 * Один из четверых называет слово, остальные его запоминают. Потом так делает следующий. И
 * так восемь раз, по два раза каждый соответственно, но не два раза подряд. В конце, барды
 * хором поют песню, вызывая бурные овации посетителей зала и недовольство хозяина таверны
 * столь кратким произведением.
 * Для решения этой задачи нужно воспользоваться классом Exchanger(иначе как барды будут друг
 * другу что-то говорить?) и классом Phaser (иначе как барды поймут, когда нужно делиться
 * словом?)
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser();
        Exchanger <String> exchanger = new Exchanger<>();

        String song_1 = "Почему все не так, вроде все как всегда " + "То же небо опять голубое, тот же лес, " + "Тот же воздух и та же вода " + "Только он не вернулся из боя " + "Тот же лес, тот же воздух и та же вода " + "Только он не вернулся из боя";
        String song_2 = "Когда на сердце тяжесть " + "И холодно в груди, " + "К ступеням Эрмитажа " + "Ты в сумерки приди, " + "Где без питья и хлеба, " + "Забытые в веках, " + "Атланты держат небо " + "На каменных руках.";
        String song_3 = "Заплутал, не знаю где " + "Чудо чудное глядел: " + "По холодной, по воде, " + "В грязном рубище " + "Через реку, напрямик " + "Брёл, как посуху, старик - " + "То ли в прошлом его лик, " + "То ли в будущем... ";
        String song_4 = "Кавалергарды, век недолог, " + "и потому так сладок он. " + "Поёт труба, откинут полог, " + "и где-то слышен сабель звон. " + "Ещё рокочет голос струнный, " + "но командир уже в седле... " + "Не обещайте деве юной " + "любови вечной на земле! ";

        ArrayList<String> song1 = new ArrayList<>(Arrays.asList(song_1.split(" ")));
        ArrayList<String> song2 = new ArrayList<>(Arrays.asList(song_2.split(" ")));
        ArrayList<String> song3 = new ArrayList<>(Arrays.asList(song_3.split(" ")));
        ArrayList<String> song4 = new ArrayList<>(Arrays.asList(song_4.split(" ")));

        Bard bard1 = new Bard(phaser, exchanger, song1);
        Bard bard2 = new Bard(phaser, exchanger, song2);
        Bard bard3 = new Bard(phaser, exchanger, song3);
        Bard bard4 = new Bard(phaser, exchanger, song4);

        bard1.start();
        bard2.start();
        bard3.start();
        bard4.start();

        bard1.join();
        bard2.join();
        bard3.join();
        bard4.join();

        System.out.println(bard1.newSong);
        System.out.println(bard2.newSong);
        System.out.println(bard3.newSong);
        System.out.println(bard4.newSong);


    }
}