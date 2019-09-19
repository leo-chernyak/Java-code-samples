package L23_TreeSet_Comparator.Task01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = getNamesFromFile( "src/Task01/Names.txt" );

        Set<Warrior> set = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            set.add(new Warrior( names.get(i), random.nextInt(100), random.nextInt(50)));
        }

        System.out.println("The weakest is " + ((TreeSet<Warrior>) set).first());
        System.out.println("The strongest is " + ((TreeSet<Warrior>) set).last());

        try(FileOutputStream file = new FileOutputStream( "src/Task01/Result.txt" )) {
            byte [] data = ((TreeSet<Warrior>) set).first().toString().getBytes();
            file.write("The weakest is ".getBytes());
            file.write(data);
            file.write("\n".getBytes());
            file.write("The strongest is ".getBytes());
            data = ((TreeSet<Warrior>) set).last().toString().getBytes();
            file.write(data);
        } catch (IOException ex) {}
    }

    public static ArrayList<String> getNamesFromFile(String path) {
        ArrayList<String> names = new ArrayList<>();
        try(FileInputStream file = new FileInputStream( path )) {
            String namesTMP = "";
            while ( file.available() > 0 ) {
                namesTMP += (char)file.read();
            }
            names.addAll(Arrays.asList(namesTMP.split("\n" )));
        } catch (IOException ex) {}
        return names;
    }
}