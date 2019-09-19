package L18_ArrayList;

import java.util.*;

public class Col {
    /**
     * Задача 1. Создать arraylist типа string и заполнить его 10 строками. Вывести на экран
     * содержимое списка.
     */
    public static void task01(){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("" + i);
        }
        System.out.println(list);
    }

    /**
     * Задача 2. Создать arraylist типа string и заполнить его 10 строками с клавиатуры. С
     * помощью цикла найти строку максимально длины(или несколько, если таковые
     * имеются) и вывести её(их) на экран.
     */
    public static void task02() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int lenght = new Random().nextInt(5) + 2;
            String str = "";
            for (int j = 0; j < lenght; j++) {
                str += j;
            }
            list.add(str);
        }
        System.out.println(list);
        Comparator<String> cmp0 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        Comparator<String> cmp1 = (o1, o2) -> o1.length() - o2.length();
        Comparator<String> cmp = Comparator.comparingInt(String::length);
        String s = Collections.max(list, cmp);
        int coount = Collections.frequency(list, s);
        for (int i = 0; i < coount; i++) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    /**
     * Задача 3.Создать arraylist типа string и заполнить его 10 строками с клавиатуры. С
     * помощью цикла найти строку минимальной длины(или несколько, если таковые
     * имеются) и вывести её(их) на экран.
     */
    public static void task03() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int lenght = new Random().nextInt(5) + 2;
            String str = "";
            for (int j = 0; j < lenght; j++) {
                str += j;
            }
            list.add(str);
        }
        System.out.println(list);
        Comparator<String> cmp0 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        Comparator<String> cmp1 = (o1, o2) -> o1.length() - o2.length();
        Comparator<String> cmp = Comparator.comparingInt(String::length);
        String s = Collections.min(list, cmp);
        int coount = Collections.frequency(list, s);
        for (int i = 0; i < coount; i++) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    /**
     * Задача 4. Создать arraylist типа string произвольной длины. Добавлять в него строки.
     * Но не в конец, а в начало списка.
     */
    public static void task04() {
        ArrayList<String> list = new ArrayList<>();
        int size = new Random().nextInt(5) + 2;
        for (int i = 0; i < size; i++) {
            int lenght = new Random().nextInt(5) + 2;
            String str = "";
            for (int j = 0; j < lenght; j++) {
                str += j;
            }
            list.add(0, str);
        }
        System.out.println(list);
    }

    /**
     * Задача 5. Создать arraylist типа string и заполнить его 10 строками. Произвести
     * циклический сдвиг вправо 17 раз и вывести на экран.
     * Пример:
     * аааа
     * сссс
     * кккк
     * рррр
     * Сдвиг на 5 позиций:
     * рррр
     * аааа
     * сссс
     * кккк
     */
    public static void task05() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(new String[]{"аааа","сссс","кккк", "рррр" }));
        String [] array = new String[list.size()];
        int shift = 6;
        for (int i = 0; i < list.size(); i++) {
            array[ ( shift % list.size() + i ) % list.size() ] = list.get(i);
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Задача 6. Создать arraylist типа string и заполнить его 10 строками
     * с клавиатуры. С помощью цикла найти самую маленькую или
     * самую длинную строку, в зависимости от того, какая встретится
     * первой
     */
    public static void task06() {
        ArrayList<String> list = new ArrayList<>();
        int size = new Random().nextInt(10) + 2;
        for (int i = 0; i < size; i++) {
            int lenght = new Random().nextInt(5) + 2;
            String str = "";
            for (int j = 0; j < lenght; j++) {
                str += j;
            }
            list.add(0, str);
        }

        System.out.println(list);

        String max = Collections.max(list, Comparator.comparingInt(String::length));
        String min = Collections.min(list, Comparator.comparingInt(String::length));

        if (list.indexOf(max) > list.indexOf(min))
            System.out.println(min);
        else System.out.println(max);
    }
}