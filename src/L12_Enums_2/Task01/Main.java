package L12_Enums_2.Task01;

public class Main {
    public static void main(String[] args) {

        DateOfMeet[] dateOfMeets = new DateOfMeet[5];

        for (int i = 0; i < dateOfMeets.length; i++) {
            dateOfMeets[i] = new DateOfMeet (
                    (int)(Math.random() * 32),
                    Month.get(i % 12),
                    Day.get(i % 7),
                    "Title " + i,
                    "Descr " + i,
                    (int)(Math.random() * 22 + 1),
                    (int)(Math.random() * 58 + 1)
            );
        }

        for (var meet : dateOfMeets) {
            meet.show();
        }
    }
}
