package SpanishInquisition.Task02;

import java.util.Arrays;
import java.util.Random;

/**
 * Задача 2. Дан массив. Перемешать его элементы случайным образом так, чтобы каждый элемент
 * оказался на новом месте.
 */

public class Main {
    public static void main(String[] args) {
        int [] array = { 1,6,4,8,3,9 };
        System.out.println(Arrays.toString(array));
        shuffle(array);
        System.out.println(Arrays.toString(array));
    }

    public static void shuffle(int [] ar) {
        Random rnd = new Random();
        for (int i = 0; i < ar.length - 1; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}