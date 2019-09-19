package L06_DoubleArray_9.T06_DownSortRows;

import L06_DoubleArray_9.Methods;

public class Main {
    public static void main(String[] args) {
        int [][] array = {
                {1,0,1,0},
                {1,0,0,-1},
        };
        System.out.println("Array before sorting");
        Methods.print(array);
        int [][] arr = SortArrayRows(array);
        System.out.println("Array after sorting");
        Methods.print(arr);
    }

    public static int[][] SortArrayRows(int[][] array) {
        Class[] parameterTypes = new Class[1];
        int [] sums =  getEvenSumsInRows(array);
        int [] indcs =  getIndexes(sums);
        return SortArrayRowsByIndcs(array, indcs);
    }

    public static int[][] SortArrayRowsByIndcs(int[][] array, int[] indcs) {
        int[][] res = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; ++i)
        {
            for (int j = 0; j < array[i].length; ++j)
            {
                res[i][j] = array[indcs[i]][j];
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

    public static int[] getEvenSumsInRows(int[][] array) {
        int[] sums = new int[array.length];
        for (int i = 0; i < array.length; ++i)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                sums[i] += array[i][j];
            }
        }
        return sums;
    }
}