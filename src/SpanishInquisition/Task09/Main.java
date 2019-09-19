package SpanishInquisition.Task09;

/**
 * Задача 9. Составить описание класса для представления времени. Предусмотреть возможности
 * установки времени и изменения его отдельных полей (час, минута, секунда) с проверкой
 * допустимости вводимых значений. В случае недопустимых значений полей выбрасываются
 * исключения. Создать методы изменения времени на заданное количество часов, минут и секунд
 */

public class Main {
    public static void main(String[] args) {
        Time time = new Time(12,45,45);
        time.setHours(05);
    }

}

class Time {
    int hours;
    int minutes;
    int seconds;

    public Time(int hours, int minutes, int seconds) {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public void setHours(int hours) {
        if (hours < 0 || hours > 23)
            throw new IllegalArgumentException("Wrong hours");
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 59)
            throw new IllegalArgumentException("Wrong minutes");
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59)
            throw new IllegalArgumentException("Wrong seconds");
        this.seconds = seconds;
    }
}