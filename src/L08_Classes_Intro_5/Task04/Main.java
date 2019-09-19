package L08_Classes_Intro_5.Task04;

public class Main {
    public static void main(String[] args) {
        // Create students
        Student [] students = new Student[10];
        int up = 3;
        // Initialize students
        for (int i = 0; i < students.length; ++i) {
            int [] ratings = new int[5];
            for (int j = 0; j < ratings.length; ++j)
            {
                ratings[j] = i % 6;
            }
            students[i] = new Student("John", "Doe" + i, i, ratings);
        }
        // sort students
        for (int i = 0; i < students.length; ++i) {
            for (int j = 0; j < students.length - i - 1; ++j) {
                if (students[j].gpa() > students[j + 1].gpa()) {
                    Student tmp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = tmp;
                }
            }
        }

        // print students
        for (int i = 0; i < students.length; ++i) {
            students[i].print();
        }

        System.out.println();

        // print students with 4 or 5
        for (var student : students) {
            if (student.equal(4))
                System.out.println(student.LastName + " " + student.numberGroup);
        }

    }
}
