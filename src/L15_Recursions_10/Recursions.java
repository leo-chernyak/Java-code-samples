package L15_Recursions_10;

import java.util.Scanner;

public class Recursions {

    static int i = 0;

    public static String task01(int n) {
        if ( n == 0 ) return "";
        return n + " " + task01(n - 1 );
    }

    public static void task011(int n) {
        if (n > 0) {
            task011(n - 1);
            System.out.print(n + " ");
        }
    }

    public static String task012(int n) {
        if (n > 0) {
            return task012(n-1) + n + " ";
        }
        return "";
    }

    public static void task02(int a, int b) {
        System.out.print(a + " ");
        if (a == b) return;
        else if (a > b) a--;
        else if (a < b) a++;
        task02( a, b );
    }

    public static int task03(int m, int n) {
        i++;

        if (m == 0) return n + 1;

        if (m > 0 && n == 0) return task03(m-1, 1);

        if (m > 0 && n > 0) return task03(m - 1, task03(m, n - 1) );

        return 0;
    }

    public static int task04(int n) {
        if ( n < 10 )
            return n;
        return n % 10 + task04(n / 10 );
    }

    public static void task05(int n) {
        if ( n > 0 ) {
            System.out.print( n % 10 + " ");
            task05( n / 10);
        }
    }

    public static void task06(int n) {
        if ( n >= 10 )
            task06( n / 10);
        System.out.print( n % 10  + " ");
    }

    /*
    Дано натуральное число n>1. Выведите все простые множители этого числа в порядке неубывания с
учетом кратности. Алгоритм должен иметь сложность O(logn).
     */

    public static void task07(int n, int m) {
        if (n/2 < m) {
            System.out.println(n);
            return;
        }
        if (n % m == 0) System.out.print(m + " ");
        if (n != m) task07(n, ++m);
    }

    public static void task007(int n, int m) {
        if (n == m) {
            System.out.print(m + " ");
            return;
        }
        if (n % m == 0) {
            System.out.print(m + " ");
            task007(n / m, 2);
        }
        else task007(n, ++m);
    }

    /*
    Задача 8. Палиндром
Дано слово, состоящее только из строчных латинских букв. Проверьте, является ли это слово
палиндромом. Выведите YES или NO.
При решении этой задачи нельзя пользоваться циклами.
     */

    public static String task08(String str) {
        if (str.length() <= 1) return "YES";
        if ( str.charAt(0) != str.charAt(str.length() - 1) ) return "NO";
        return task08(str.substring(1, str.length() - 1));
    }

    /*
    Вывести нечетные числа последовательности
Дана последовательность натуральных чисел (одно число в строке), завершающаяся числом 0. Выведите
все нечетные числа из этой последовательности, сохраняя их порядок.
В этой задаче нельзя использовать глобальные переменные и передавать какие-либо параметры в
рекурсивную функцию. Функция получает данные, считывая их с клавиатуры. Функция не возвращает
значение, а сразу же выводит результат на экран. Основная программа должна состоять только из вызова
этой функции.
     */

    public static void task09() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a value: ");
        int value = sc.nextInt();
        if (value == 0) return;
        if (value % 2 == 1)
            System.out.println(value);
        task09();
    }

    /*
    Максимум последовательности
Дана последовательность натуральных чисел (одно число в строке), завершающаяся числом 0.
Определите наибольшее значение числа в этой последовательности.
В этой задаче нельзя использовать глобальные переменные и передавать какие-либо параметры в
рекурсивную функцию. Функция получает данные, считывая их с клавиатуры. Функция возвращает
единственное значение: максимум считанной последовательности. Гарантируется, что
последовательность содержит хотя бы одно число (кроме нуля).
     */

    public static int task10() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a value: ");
        int value = sc.nextInt();
        if (value == 0) return Integer.MIN_VALUE;
        int res = task10();
        return value > res ? value : res;
    }
}