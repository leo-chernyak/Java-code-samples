package L12_Enums_2.Task02;

import L12_Enums_2.Task01.*;

public class Main {
    public static void main(String[] args) {
        normalTest();
        //errorTest();
    }

    public static void addMeet(BookOfMeeting meets, DateOfMeet meet) {
        int result = meets.addMeet( meet );
        if (result > 0) {
            System.out.println("Bad");
            meet.show();
            meets.printMeet(result);
        }
        else if (result < 0) System.out.println("not founded");
    }

    public static void errorTest() {
        BookOfMeeting meets = new BookOfMeeting();

        DateOfMeet meet = new DateOfMeet (
                (int)(Math.random() * 30 + 1),
                Month.get(0),
                Day.get(0),
                "Title ",
                "Descr ",
                (int)(Math.random() * 22 + 1),
                (int)(Math.random() * 58 + 1)
        );

        // Вводим ошибку
        addMeet(meets, meet);

        for (int i = 0; i < Month.values().length; i++) {
            for (int j = 1; j <= Month.get(i).getCountDays(); j++) {
                DateOfMeet meetTest = new DateOfMeet(
                        j,
                        Month.get(i),
                        Day.get((j - 1) % 7),
                        "",
                        "",
                        10, 10
                );
                addMeet(meets, meetTest);
            }
        }
    }

    public static void normalTest() {
        BookOfMeeting meets = new BookOfMeeting();

        DateOfMeet meet = new DateOfMeet (
                31,
                Month.get(0),
                Day.get(0),
                "Title ",
                "Descr ",
                (int)(Math.random() * 22 + 1),
                (int)(Math.random() * 58 + 1)
        );

        DateOfMeet meet1 = new DateOfMeet (
                1,
                Month.get(1),
                Day.get(0),
                "Title ",
                "Descr ",
                (int)(Math.random() * 22 + 1),
                (int)(Math.random() * 58 + 1)
        );

        addMeet(meets, meet);
        addMeet(meets, meet1);

        meets.printMeets();
    }

}