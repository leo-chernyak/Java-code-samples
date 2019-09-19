package L09_Classes_Base_10.Task09;
/*
Создать класс “Date” с тремя целочисленными показателями для определения дня, месяца и года.
Добавить в класс функции для определения по дате времени года, номера дня в году, а также функцию
для расчета количества дней между двумя датами, принимающую на вход объект данного класса.
 */

public class Date {
    private static int [] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int day = 1;
    int month = 1;
    int year = 1991;
    Date(int day, int month, int year) {
        if (day < 1 || day > 31)
            throw new IndexOutOfBoundsException("The day out of range");
        if (month < 1 || month > 12)
            throw new IndexOutOfBoundsException("The month out of range");
        if (year < 1)
            throw new IndexOutOfBoundsException("The year out of range");
        this.day = day;
        this.month = month;
        this.year = year;
    }

    private Date(Date date) {
        this(date.day, date.month, date.year);
    }

    public String season() {
        return seasonByMonth(month);
    }

    public static String seasonByDays(int days) {
        int sumOfDays = 0;
        int month = 0;
        for (int i = 0; i < daysInMonth.length; i++) {
            sumOfDays += daysInMonth[i];
            if (sumOfDays >= days)
            {
                month = i + 1;
                break;
            }
        }
        return seasonByMonth(month);
    }

    public int diffInDays(Date date) {
        int currDay = this.day;
        int currMonth = this.month;
        int currYear = this.year;
        int diffDays = 0;
        for (int year = currYear; year <= date.year; ++year)
        {
            int maxMonth = year == date.year ? date.month : 12;
            for (int month = currMonth; month <= maxMonth; ++month)
            {
                int maxDay = (year == date.year && month == date.month)
                        ? date.day
                        : (isLeap(year) && month == 2) ? 29 : daysInMonth[month - 1];
                for (int day = currDay; day <= maxDay; ++ day)
                {
                    diffDays++;
                }
                currDay = 1;
            }
            currMonth = 1;
        }
        return diffDays - 1;
    }

    public static void swap(Date date1, Date date2 ) {
        date1 = date2;
    }

    private static String seasonByMonth(int month) {
        if (month == 12  || month <= 2)
            return "winter";
        if (month >= 3  && month <= 5)
            return "fall";
        if (month >= 6  && month <= 8)
            return "summer";
        if (month >= 9  || month <= 11)
            return "autumn";
        return "unidentified";
    }

    private static boolean isLeap(int year){
        if ( year % 400 == 0)
            return true;

        if (year % 100 == 0)
            return false;

        if (year % 4 == 0)
            return true;

        return false;
    }

    private int compare(Date date) {
        if (this.year != date.year)
            return date.year - this.year;

        if (this.month != date.month)
            return date.month - this.month;

        if (this.day != date.day)
            return date.day - this.day;

        return 0;
    }

    @Override
    public String toString() { return day + "." + month + "." + year; }
}
