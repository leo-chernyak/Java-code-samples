package L23_TreeSet_Comparator.Task02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Здание 2. Создать класс маг с полями количество здоровье, количество магии и имя. Написать
 * компаратор для сравнения этих двух магов по количеству наносимого урона. Составить список
 * самых сильных магов с использованием treeSet.
 */

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = L23_TreeSet_Comparator.Task01.Main.getNamesFromFile( "src/Task02/Names.txt" );
        TreeSet<Wizard> wizards = createWizardsByNames( names );

        Wizard wizard = wizards.higher(new Wizard(null, 0, 30));
        SortedSet<Wizard> strongestWizards = wizards.tailSet(wizard);
        strongestWizards.forEach(System.out::println);

        try(FileOutputStream file = new FileOutputStream( "src/Task02/Result.txt" )) {
            file.write("The stringest wizards: \n".getBytes());
            for (Wizard wizard1 : strongestWizards) {
                byte [] data = wizard1.toString().getBytes();
                file.write(data);
                file.write("\n".getBytes());
            }
        } catch (IOException ex) {}
    }

    public static TreeSet<Wizard> createWizardsByNames ( ArrayList<String> names ) {
        TreeSet<Wizard> wizards = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            wizards.add(new Wizard(names.get( random.nextInt(200) ), random.nextInt(100), random.nextInt(50)));
        }
        return wizards;
    }
}