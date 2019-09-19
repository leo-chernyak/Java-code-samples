package L12_Enums_2.Task01;

public enum Month {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTENBER(30),
    OCTOBER(31),
    NOVENBER(30),
    DECEMBER(31);

    private int countDays;

    Month(int countDays) {
        this.countDays = countDays;
    }

    public int getCountDays() {
        return countDays;
    }

    public static Month get(int index) {
        return Month.values()[index];
    }

    public static Month get(String m) {
        return Month.valueOf(m.toUpperCase());
    }
}