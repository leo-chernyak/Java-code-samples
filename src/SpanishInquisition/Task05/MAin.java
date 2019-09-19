package SpanishInquisition.Task05;

/**
 * Задача 5.Создать квадратную матрицу, на диагонали которой находятся тройки, выше диагонали
 * находятся двойки, остальные элементы равна единице.
 */

public class MAin {
    public static void main(String[] args) {
        int size = 3;
        int [][] array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (i == j)
                    array[i][j] = 3;
                else if (i < j)
                    array[i][j] = 2;
                else if (i > j)
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
