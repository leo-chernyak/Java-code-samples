package L06_DoubleArray_9.T09_MatrixMultiply;

import L06_DoubleArray_9.Methods;

public class Main {
    static int [][] mat1 = {
            {2, 1},
            {-3, 0},
            {4, -1},
    };

    static int [][] mat2 = {
            {5, -1, 6},
            {-3, 0, 7},
    };

    public static void main(String[] args)
    {
        System.out.println("Result of multiply two matrix is");
        Methods.print(MultiplyMatrix(mat1, mat2));
    }

    public static int[][] MultiplyMatrix(int[][] lhs, int[][] rhs) {
        if (lhs[0].length != rhs.length)
            return new int[0][0];
        int [][] rhs2 = TMatrix(rhs);
        int [][] res = new int[lhs.length][rhs2.length];
        for (int i = 0; i < res.length; ++i)
        {
            for (int j = 0; j < res[0].length; ++j)
            {
                res[i][j] = MultiplyMatrix(lhs[i], rhs2[j]);
            }
        }
        return res;
    }

    public static int MultiplyMatrix(int[] lhs, int[] rhs) {
        int res = 0;
        for (int i = 0; i < lhs.length; ++i) {
            res += lhs[i]*rhs[i];
        }
        return res;
    }

    public static int[][] TMatrix(int[][] array) {
        int[][] new_aray = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[0].length; ++j) {
                new_aray[j][i] = array[i][j];
            }
        }
        return new_aray;
    }
}
