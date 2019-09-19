package SixTasksNumbers;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /**
         * 1.Два нечетных простых числа, отличающиеся на 2, называются близнецами.
         * Например, числа 5 и 7. Напишите программу, которая будет находить все числа-близнецы на отрезке [2; 1000].
         */
        Solution.task01();
        /**
         * 2.Найдите количество и сумму цифр в данном натуральном числе.
         */
        Solution.task02(156);
        /**
         * 3.Дано натуральное число. Поменяйте в нем порядок цифр на обратный.
         */
        System.out.println("Task03: " + Solution.task03(156));
        /**
         * 4.Числа, одинаково читающиеся слева направо и справа налево, называются палиндромами.
         * Например, 1223221. Напишите программу нахождения всех палиндромов на данном отрезке.
         */
        Solution.task04(10, 20);
        /**
         * 5.Числа, запись которых состоит из двух одинаковых последовательностей цифр, называются симметричными.
         * Например, 357357 или 17421742. Определите, является ли данное натуральное число симметричным.
         */
        System.out.println();
        System.out.println(Solution.task05(357357));
        /**
         * 6.Если сложить все цифры какого-либо натурального числа, затем — все цифры найденной суммы и так далее,
         * то в результате получим однозначное число (цифру), которое называется цифровым корнем данного числа.
         * Например, цифровой корень числа 561 равен 3 (5 + 6+1 — 12, 1+2 = 3).
         * Написать программу для нахождения числового корня данного натурального числа.
         */
        System.out.println(Solution.task06(561));
    }
}

class Solution {
    static void task01() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() + ": ");
        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();
        int lhs = 2;
        lhs = lhs % 2 == 0 ? lhs  + 1 : lhs;
        int rhs = 1000;
        for (int i = lhs; i < rhs - 1; i+=2) {
            list.add(new Pair<>(i, i + 2));
        }
        for (Pair<Integer, Integer> pair : list) {
            System.out.print(pair + " - ");
        }
        System.out.println();
    }
    static void task02(int n) {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() + ": ");
        ArrayList<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 10);
            n /= 10;
        }
        System.out.print(list.size() + " - ");
        System.out.println(list.stream()
                .mapToDouble(a -> a)
                .sum());
    }
    static int task03(int n) {
        int res = 0;
        while (n != 0) {
            res *= 10;
            res += n % 10;
            n /= 10;
        }
        return res;
    }
    static void task04(int lhs, int rhs) {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() + ": ");
        for (int i = lhs; i <= rhs; i++) {
            if (i == task03(i)) {
                System.out.print(i + " ");
            }
        }
    }
    static boolean task05(int i) {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() + " value: " + i +": ");
        String value = Integer.toString(i);
        if ( value.length() % 2 != 0 ) return false;
        String lhs = value.substring(0, value.length() / 2);
        String rhs = value.substring( value.length() / 2);
        return lhs.equals(rhs);
    }
    static int task06(int i) {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() + ": ");
        int sum = 0;
        while (i > 10 ) {
            sum = 0;
            while (i != 0) {
                sum += i % 10;
                i /= 10;
            }
            i = sum;
        }
        return sum;
    }
}

class Pair<First, Second> {
    First first;
    Second second;
    public Pair(First first, Second second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public String toString() {
        return first + " " +  second;
    }
}