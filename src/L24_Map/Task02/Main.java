package L24_Map.Task02;

import java.io.*;
import java.util.*;

/**
 * Задача 2. В средневековом городе живёт король, 10 дворян, 25 рыцарей и 100 обычных крестьян. В
 * город пришла чума. Каждый день все жители этого города теряют часть своего здоровья. Определить
 * сколько и каких жителей останется в городе после 5 дней чумы.
 * Нужно:
 * Создать 4 класса - король, дворяне, рыцари, крестьяне. Чем выше сословие, тем более
 * здоровый человек
 * Добавить их в ArrayList.
 * “Каждый день” у жителей отнимается случайное количество здоровья.
 */

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = getNamesFromFile("src/Task02/Names");
        List<Human> humans = createHumansByNames(names);
        for (int i = 0; i < 5; i++) {
            humans.forEach(human -> human.downHealth(Human.random.nextInt(25)));
        }
        humans.removeIf(human -> ! human.isALive());
        TreeSet<Human> peoples = new TreeSet<>(new HunamComparator());
        peoples.addAll(humans);
        peoples.forEach(human -> System.out.println(human));
        writeDataIntoFile(humans, "src/Task02/Result.txt");
    }

    private static void writeDataIntoFile(Collection collection, String path) {
        try(FileOutputStream output = new FileOutputStream(path);
            BufferedOutputStream writer = new BufferedOutputStream(output)) {
            for (Object o : collection) {
                writer.write(o.toString().getBytes());
                writer.write("\n".getBytes());
            }
        }
        catch (IOException ignored){ }
    }
    private static ArrayList<Human> createHumansByNames(ArrayList<String> names) {
        ArrayList<Human> humans = new ArrayList<>();
        Random r = new Random();
        int size = names.size();
        humans.add(new King(names.get(r.nextInt(size))));
        for (int i = 0; i < 10; i++) {
            humans.add(new Nobleman(names.get(r.nextInt(size))));
        }
        for (int i = 0; i < 25; i++) {
            humans.add(new Knight(names.get(r.nextInt(size))));
        }
        for (int i = 0; i < 100; i++) {
            humans.add(new Peasant(names.get(r.nextInt(size))));
        }
        return humans;
    }
    private static ArrayList<String> getNamesFromFile(String path) {
        ArrayList<String> names = new ArrayList<>();
        try (FileInputStream input = new FileInputStream(path);
             BufferedInputStream reader = new BufferedInputStream(input)) {
            String name = "";
            while (reader.available() > 0) {
                char ch = (char) reader.read();
                if (ch == '\n') {
                    names.add(name);
                    name = "";
                } else name += ch;
            }
        } catch (IOException ignored) {}
        return names;
    }
}