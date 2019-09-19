package L06_DoubleArray_9.T04_DownSortColumns;

import L06_DoubleArray_9.Methods;

public class Main {
    public static void main(String[] args) {
        int [][] array = {
                {1, 3, 5, -1},
                {1, 3, 1, -1},
        };
        System.out.println("Array before sorting");
        Methods.print(array);
        int [][] arr = SortArrayByColumn(array);
        System.out.println("Array after sorting");
        Methods.print(arr);
    }

    public static int[][] SortArrayByColumn(int[][] array) {
        int [] sums =  getSumsByColumn(array);
        int [] indcs =  getIndexes(sums);
        return SortArrayByIndices(array, indcs);
    }

    public static int[][] SortArrayByIndices(int[][] array, int[] indcs) {
        int[][] res = new int[array.length][array[0].length];

        for (int i = 0; i < array.length; ++i)
        {
            for (int j = 0; j < array[i].length; ++j)
            {
                res[i][j] = array[i][indcs[j]];
            }
        }
        return res;
    }

    public static int[] getIndexes(int[] array) {
        int[] indcs = new int[array.length];
        for (int i = 0; i < indcs.length; ++i)
        {
            indcs[i] = i;
        }
        Methods.DownSort(array, indcs);
        return indcs;
    }

    public static int[] getSumsByColumn(int[][] array) {
        int[] sums = new int[array[0].length];
        for (int j = 0; j < array[0].length; ++j)
        {
            for (int i = 0; i < array.length; ++i)
            {
                sums[j] += array[i][j];
            }
        }
        return sums;
    }
}
