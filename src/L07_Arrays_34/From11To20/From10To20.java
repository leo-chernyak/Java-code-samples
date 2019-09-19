package L07_Arrays_34.From11To20;

import L07_Arrays_34.From01To10.From01To10;

import java.util.Arrays;

public class From10To20 {
    public static void main(String[] args) {
        int [] array1 = new int[] {1, 5, 5, 2, 10, 15};
        int [] array11 = new int[] {0, 0, 0, 0, 0, 0};
        double [] array1d = new double[] {5, -5, 5, 2, 10, 15};
        int [][] array2 = new int[][] {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
        };
        System.out.println("11.Array before flip are " + Arrays.toString(array1));
        Number11(array1);
        System.out.println("   Array after flip are  " + Arrays.toString(array1));
        System.out.println("12.Array before shift are " + Arrays.toString(array1));
        Number12(array1);
        System.out.println("   Array after shift are  " + Arrays.toString(array1));
        System.out.println("13.Minimum element in a one-dimensional array " + Arrays.toString(array1) + " is " + Number13(array1));
        System.out.println("14.Maximum element in a one-dimensional array " + Arrays.toString(array1) + " is " + Number14(array1));
        System.out.println("15.Are all elements in an array different " + Arrays.toString(array1) + " is " + Number15(array1));
        System.out.println("16.Number of different elements in the array " + Arrays.toString(array11) + " is " + Number16(array11));
        System.out.println("17.The number of elements equal to zero " + Arrays.toString(array1) + " is " + Number17(array1, 0));
        int k = 10;
        System.out.println("18.Number of elements less than " + k + " from " + Arrays.toString(array1) + " is " + Number18(array1, k));
        System.out.println("19.Before normalize " + Arrays.toString(array1d) );
        Number19(array1d);
        System.out.println("   After normalize " + Arrays.toString(array1d) );
        System.out.println("20.The two-dimensional array elements ");
        From01To10.print(array2);
        System.out.println("And this sum of this elements is " + Number20(array2));

    }

    public static void Number11(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            if (i > array.length - 1 - i)
                break;
            From01To10.swap(array, i , array.length - i - 1);
        }
    }

    public static void Number12(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            From01To10.swap(array, 0 , i);
        }
    }

    public static int Number13(int[] array) {
        return From01To10.Number03(array);
    }

    public static int Number14(int[] array) {
        return From01To10.Number02(array);
    }

    public static boolean Number15(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if ( array[i] == array[i + 1])
                return false;
        }
        return true;
    }

    public static int Number16(int[] array) {
        sort(array);
        int count = array.length;
        for (int i = 0; i < array.length - 1; ++i) {
            if ( array[i] == array[i + 1])
                count--;
        }
        return count;
    }

    public static int Number17(int[] array, int value) {
        int count = 0;
        for (int i = 0; i < array.length; ++i) {
            if ( array[i] == value)
                count++;
        }
        return count;
    }

    public static int Number18(int[] array, int value) {
        int count = 0;
        for (int i = 0; i < array.length; ++i) {
            if ( array[i] < value)
                count++;
        }
        return count;
    }

    public static void Number19(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; ++i) {
            sum += array[i] >= 0 ? array[i] : 0;
        }
        for (int i = 0; i < array.length; ++i) {
            if (array[i] >= 0)
                array[i] /= sum;
        }
    }

    public static int Number20(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; ++i) {
            sum += sums(array[i]);
        }
        return sum;
    }

    public static void sort(int[] array) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; ++i) {
                if (array[i] > array[i + 1])
                {
                    sorted = false;
                    From01To10.swap(array, i , i + 1);
                }
            }
        }
    }


    public static int sums(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; ++i) {
            sum += array[i];
        }
        return sum;
    }

}
