package L12_Enums_2.Task02;

import L12_Enums_2.Task01.*;

public class BookOfMeeting {
    private DateOfMeet[] meets = new DateOfMeet[365];
    public BookOfMeeting() {
        int z = 0;
        Day.currDay = Day.SUNDAY;
        for (int i = 0; i < Month.values().length; i++) {
            for (int j = 1; j <= Month.get(i).getCountDays(); j++) {
                meets[z] = new DateOfMeet(
                        j,
                        Month.get(i),
                        Day.nextDay() /*Day.get(z % 7)*/,
                        "",
                        "",
                        -1, -1
                );
                z++;
            }
        }
    }

    public int addMeet(DateOfMeet meet) {
        for(int i = 0 ; i < meets.length; i++) {
            if (meets[i].getMonth() == meet.getMonth() && meets[i].getNumber() == meet.getNumber() ) {
                if (meets[i].getMinutes() < 0)
                { meets[i].setMeet(meet); return 0; }
                else return i;
            }
        }
        return -1;
    }

    public int printMeets() {
        System.out.println("All meetings:");
        int countMeets = 0;
        for(var meet : meets) {
            if (meet.getMinutes() > 0)
                meet.show(); countMeets++;
        }
        return countMeets;
    }

    public void printMeet(int indx) {
        meets[indx].show();
    }
}