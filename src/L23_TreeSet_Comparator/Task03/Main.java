package L23_TreeSet_Comparator.Task03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

/**
 * Задание 3. Создать класс рыцарь с полями количество здоровья, количество брони, количеством
 * урона и именем. Провести рыцарский турнир и узнать кто победил используя treeSet, по
 * критериям количество здоровья, количество брони и наносимый урон.
 */

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = L23_TreeSet_Comparator.Task01.Main.getNamesFromFile( "src/Task02/Names.txt" );
        TreeSet<Knight> knights = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            knights.add(new Knight(
                    names.get(random.nextInt(names.size())),
                    random.nextInt(50) + 50,
                    random.nextInt(30),
                    random.nextInt(50))
            );
        }
        knights.forEach(System.out::println);
        System.out.println("\nSurvived: " + knights.last());

        try(FileOutputStream file = new FileOutputStream("src/Task03/Result.txt")) {
            file.write("Survived: ".getBytes());
            file.write(knights.last().toString().getBytes());
        }
        catch (IOException ex) {
        }

    }
}