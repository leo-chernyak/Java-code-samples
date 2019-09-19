package L06_DoubleArray_9.T07_RowsWithPrimeNumbers;

import L06_DoubleArray_9.Methods;

public class Main {
    public static void main(String[] args) {
        int[][] array = {
                {1, 1, 1, 4},
                {997, 4, 4, 4},
        };

        System.out.println("Array");
        Methods.print(array);
        System.out.println("Count rows that contain prime numbers is " + CountRowsWithPrimeNumbers(array));
    }

    public static boolean IsSimple(int value) {
        for (int i = 2; i <= Math.sqrt(value); ++i) {
            if (value % i == 0)
                return false;
        }
        return true;
    }

    public static int CountRowsWithPrimeNumbers(int[][] array) {
        int countRowsWithPrimeNumbers = 0;
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {
                if (IsSimple(array[i][j]))
                    countRowsWithPrimeNumbers++; break;
            }
        }
        return countRowsWithPrimeNumbers;
    }
}
