package L12_Enums_2.Task01;

public class DateOfMeet {
    private Month month;
    private Day day;
    private String title;
    private String description;
    private int number;
    private int minutes;
    private int hour;

    public DateOfMeet(int number, Month month, Day day, String title, String description, int hour, int minutes) {
        this.month = month;
        this.day = day;
        this.title = title;
        this.description = description;
        this.number = number;
        this.minutes = minutes;
        this.hour = hour;
    }

    public void show() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return
                "number=" + number +
                ", month=" + month +
                ", day=" + day +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", hour=" + hour +
                ", minutes=" + minutes


                ;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMeet(DateOfMeet dateOfMeet) {
        this.title = dateOfMeet.title;
        this.description = dateOfMeet.description;
        this.minutes = dateOfMeet.minutes;
        this.hour = dateOfMeet.hour;
    }

    public Month getMonth() {
        return month;
    }

    public int getNumber() {
        return number;
    }
}