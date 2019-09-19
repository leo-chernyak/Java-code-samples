package L12_Enums_2.Task01;

public enum Day {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private final int value;

    public static Day currDay = Day.SUNDAY;

    Day(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static Day nextDay() {
        int val = currDay.value;
        if (val == 7)
            currDay = Day.values()[0];
        else
            currDay = Day.values()[val];
        return currDay;
    }


    public static Day get(int index) {
        return Day.values()[index];
    }

    public static Day get(String m) {
        return Day.valueOf(m.toUpperCase());
    }
}
