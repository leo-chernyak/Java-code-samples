package SpanishInquisition.Task06;

import java.util.Random;

/**
 * Задача 6. Сформировать квадратную матрицу n x n, на диагонали которой находятся случайные
 * числа из диапазона [1; 9], а остальные числа равны 1.
 */
public class Main {
    public static void main(String[] args) {
        int size = 3;
        int [][] array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (i == j)
                    array[i][j] = new Random().nextInt(10);
                else
                    array[i][j] = 1;
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
