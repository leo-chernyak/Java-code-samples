package L27_Serialization_Files.Task02;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    // полями фамилия, имя, массив с оценками и поле со средним
    private final String secondName;
    private final String name;
    private ArrayList<Integer> grades;
    private transient double avg;

    public Student(String secondName, String name, ArrayList<Integer> grades) {
        this.secondName = secondName;
        this.name = name;
        this.grades = grades;
        this.avg = grades.stream().mapToInt(integer ->  integer).sum() / grades.size();
    }

    @Override
    public String toString() {
        return secondName + " " + name + " " + avg;
    }
}