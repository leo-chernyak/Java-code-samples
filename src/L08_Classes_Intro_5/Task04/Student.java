package L08_Classes_Intro_5.Task04;

import java.util.Arrays;

public class Student {
    String firstName;
    String LastName;
    int numberGroup;
    int [] academicPerformance;
    Student(String firstName, String lastName, int group, int [] academicPerformance){
        this.academicPerformance = academicPerformance;
        this.firstName = firstName;
        this.LastName = lastName;
        this.numberGroup = group;
    }

    Student(String firstName, String lastName, int group){
        this(firstName, lastName, group, new int[]{1,2,3,4,5} );
    }

    Student(String firstName, String lastName){
        this(firstName, lastName, 0, new int[]{1,2,3,4,5} );
    }

    Student(String firstName){
        this(firstName, "Doe", 0, new int[]{1,2,3,4,5} );
    }

    Student(){
        this("John", "Doe", 0, new int[]{1,2,3,4,5} );
    }

    public double gpa() {
        double gpa = 0;
        for (var value : academicPerformance)
            gpa += value;
        return gpa / academicPerformance.length;
    }

    public void print() {
        System.out.println(firstName + " " + LastName + " " + numberGroup + " " + Arrays.toString(academicPerformance) + " " + gpa());
    }

    public boolean equal(int value) {
        for (var val : academicPerformance) {
            if (value != val)
                return false;
        }
        return true;
    }
}
