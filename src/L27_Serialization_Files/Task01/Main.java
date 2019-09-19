package L27_Serialization_Files.Task01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Задача 1. Создать класс студент с полями фамилия, имя, массив с оценками и поле со средним
 * значением оценки. Используя сериализацию записать в файл данные о 10 студентах и
 * впоследствии считать из файла и вывести информацию о них.
 */

public class Main {
    public static void main(String[] args) {
        List<Student> students = generateStudents();
        students.forEach(System.out::println);
        saveIntoFile("src/L27_Serialization_Files/Task01/Result.txt", students);
        List<Student> studentsFromFile = getStudentsFromFile("src/L27_Serialization_Files/Task01/Result.txt");
        System.out.println();
        studentsFromFile.forEach(System.out::println);
    }

    private static List<Student> generateStudents() {
        ArrayList<Student> students = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> grades = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                grades.add( random.nextInt(5) );
            }
            students.add(new Student("Second_"+i, "First_"+i, grades));
        }
        return students;
    }
    private static List<Student> getStudentsFromFile(String path) {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            return ((ArrayList<Student>)in.readObject());
        }catch (Exception ignored) {}
        return null;
    }
    private static void saveIntoFile(String path, List list) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(list);
        }catch (IOException ignored) {}
    }
}