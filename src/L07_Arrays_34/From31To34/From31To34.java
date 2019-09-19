package L07_Arrays_34.From31To34;

import L07_Arrays_34.From01To10.From01To10;

import java.util.Arrays;

import static L07_Arrays_34.From01To10.From01To10.print;
import static L07_Arrays_34.From01To10.From01To10.swap;
import static L07_Arrays_34.From11To20.From10To20.Number20;
import static L07_Arrays_34.From21To30.From21To30.swap;

public class From31To34 {
    public static void main(String[] args) {
        int[][][] array3 = new int[][][]{
                {
                        {3, 2, 1},
                        {3, 4, 1},
                },
                {
                        {1, 7, 1},
                        {1, 2, 1},
                },
                {
                        {4, 10, 1},
                        {4, 4, 1},
                },
        };

        System.out.println("31.Write in a two-dimensional array elements of the xy-plane three-dimensional array, " +
                "containing the maximum element in this three-dimensional array ");
        System.out.println("The array with max elements");
        print(Number31(array3));
        System.out.println("The full array");
        print(array3);

        System.out.println("32.Sequentially derive elements of xy-planes of a three-dimensional array with indices of z");
        Number32(array3);

        System.out.println();
        System.out.println("33.Calculate arithmetic averages for elements of each of the xy-planes three-dimensional array and output them through a comma");
        System.out.println(Arrays.toString(Number33(array3)));
        System.out.println();

        System.out.println();
        System.out.println("34.Sort in ascending order of the xy-plane of the three-dimensional array by increasing the arithmetic average of the elements of each xy-plane data.");
        System.out.println("Before");
        From01To10.print(array3);
        System.out.println("After");
        Number34(array3);
        From01To10.print(array3);
    }

    public static int[][] Number31(int[][][] array) {
        int idx = 0;
        for (int i = 0; i < array.length; ++i) {
            if (max(array[idx]) < max(array[i])) {
                idx = i;
            }
        }
        return array[idx];
    }

    public static void Number32(int[][][] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.println("z=" + i);
            for (int j = 0; j < array[i].length; ++j) {
                for (int z = 0; z < array[i][j].length; ++z) {
                    System.out.print(array[i][j][z] + " ");
                }
                System.out.println();
            }
        }
    }

    public static double[] Number33(int[][][] array) {
        double[] res = new double[array.length];
        int idx = 0;
        for (int i = 0; i < array.length; ++i) {
            res[i] = (double) Number20(array[i]) / (array[i].length * array[i][0].length);
        }
        return res;
    }

    public static int[] GetIndexes(double[] array) {
        int[] indxs = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            indxs[i] = i;
        }
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            int id = 0;
            for (int i = 0; i < array.length - 1; ++i) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swap(indxs, i, i + 1);
                }
                id = i;
            }
        }
        return indxs;
    }

    public static void Number34(int[][][] array3) {
        double[] array = Number33(array3);
        int[] indxs = new int[array.length];
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            int id = 0;
            for (int i = 0; i < array.length; ++i) {
                if (array[id] > array[i]) {
                    swap(array, id, i);
                    swap(array3, id, i);
                    sorted = false;
                }
                id = i;
            }
        }
    }

    public static int max(int[][] array) {
        int max = array[0][0];
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {
                if (max < array[i][j])
                    max = array[i][j];
            }
        }
        return max;
    }

}