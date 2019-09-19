package L09_Classes_Base_10.Task08;

public class Main {
    public static void main(String[] args) {
        // Задание усложнено!!!
        // Теперь класс Polynomial считает ЛЮБЫЕ производные типа Ax^? + Bx^? + ... + c
        // при любом количестве параметров с любыми степенями. Пример 9х^(-5) + 0 при х = 1, производная берётся 3 порядка.
        System.out.println(new Polynomial(new double[]{9}, new int[]{-5}, 0).calculate(1, 3));
    }
}
