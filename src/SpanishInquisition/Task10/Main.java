package SpanishInquisition.Task10;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Задача 10. Класс Абонент: Идентификационный номер, Фамилия, Имя, Отчество, Адрес, Номер
 * кредитной карточки, Дебет, Кредит, Время междугородных и городских переговоров; Конструктор;
 * Методы: установка значений атрибутов, получение значений атрибутов, вывод информации.
 * Создать массив объектов данного класса. Вывести сведения относительно абонентов, у которых
 * время городских переговоров превышает заданное. Сведения относительно абонентов, которые
 * пользовались междугородной связью.
 */

public class Main {
    public static void main(String[] args) {
        Subscriber [] subscribers = careateSubscribers();

        ArrayList<Subscriber> sub = new ArrayList<>(Arrays.asList(subscribers));

        System.out.println("City Calls more than 500");
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getCityCalls() > 500) {
                System.out.println(subscriber);
            }
        }


        System.out.println("Intercity Calls exist");
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getIntercityCalls() > 0)
                System.out.println(subscriber);
        }
    }

    public static Subscriber [] careateSubscribers() {
        Subscriber [] subscribers = new Subscriber[10];
        for (int i = 0; i < subscribers.length; i++) {
            subscribers[i] = new Subscriber("Ivanov"+i, "Ivan"+i, "Ivanovich"+i,
                    "Vashington street "+(int)(Math.random()*50),
                    (int)(Math.random()*1000000000), (int)(Math.random()*700),
                    (int)(Math.random()*700)
                    );
        }
        return subscribers;
    }
}

class Subscriber {
    private static int id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String address;
    private int cardNumber;
    private int intercityCalls;
    private int cityCalls;

    public Subscriber(String firstName, String lastName, String fatherName, String address, int cardNumber, int intercityCalls, int cityCalls) {
        this.id++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.address = address;
        this.cardNumber = cardNumber;
        this.intercityCalls = intercityCalls;
        this.cityCalls = cityCalls;
    }

    @Override
    public String toString() {
        return firstName + ' ' +
                lastName + ' ' +
                fatherName + ' ' +
                address + ' ' +
                ", cardNumber=" + cardNumber +
                ", intercityCalls=" + intercityCalls +
                ", cityCalls=" + cityCalls
                ;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getIntercityCalls() {
        return intercityCalls;
    }

    public void setIntercityCalls(int intercityCalls) {
        this.intercityCalls = intercityCalls;
    }

    public int getCityCalls() {
        return cityCalls;
    }

    public void setCityCalls(int cityCalls) {
        this.cityCalls = cityCalls;
    }
}