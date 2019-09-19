package L02_MatrixDeterminant;

public class Main
{
    private static final double[][] tast01 = {
            {12.0, 7.5, -34.3},
            {1.0, 19.8, -2.6},
            {5.2, 10.8, 3.0},
    };
    private static final double[][] tast02 = {
            {1, 2, 3, 4, 3, 4},
            {3, 1, 2, 5, 3, 3},
            {2, 3, 1, 6, 3, 5},
            {2, 3, 5, 1, 3, 7},
            {2, 3, 2, 0, 3, 9},
            {2, 3, 1, 3, 1, 7},
    };
    public static void main(String[] args) {
        System.out.println("The determinant of matrix is " + determinant(tast01));
        System.out.println("The revers matrix is:");
        printMatrix(getReverseMatrix(tast01));
    }

    public static double[][] getReverseMatrix(double[][] matrix) {
        double[][] rMatrix = getTMatrix(getMinorMatrix(matrix));
        double term = 1 / determinant(matrix);
        for(int i = 0; i < rMatrix.length; ++i) {
            for(int j = 0; j < rMatrix.length; ++j) {
                rMatrix[i][j] *= term;
            }
        }
        return rMatrix;
    }

    public static double[][] getTMatrix(double[][] matrix) {
        double[][] tMatrix = new double [matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix.length; ++j) {
                tMatrix[j][i] = matrix[i][j];
            }
        }
        return tMatrix;
    }

    public static double[][] getMinorMatrix(double[][] matrix) {
        double[][] mMatrix = new double [matrix.length][matrix.length];
        for(int i = 0; i < mMatrix.length; ++i) {
            for(int j = 0; j < mMatrix.length; ++j) {
                mMatrix[i][j] = determinant(subMatrix(matrix, i, j)) * Math.pow(-1, i + j);
            }
        }
        return mMatrix;
    }

    public static double determinant(double[][] matrix) {
        if (matrix.length == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        double term = 0;
        for(int i = 0; i < matrix.length; ++i)
            term += Math.pow(-1, i) * matrix[0][i]*determinant(subMatrix(matrix, 0, i));
        return term;
    }

    public static void printMatrix(double[][] matrix) {
        for (var singleArray: matrix) {
            for (var value: singleArray) {
                System.out.printf("%10.2f ", (int)(value * 100) / 100.0);
            }
            System.out.println();
        }
    }

    public static double[][] subMatrix(double[][] matrix, int idx, int jdx) {
        double[][] subMatrix = new double[matrix.length - 1][matrix.length - 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i < idx && j < jdx)
                    subMatrix[i][j] = matrix[i][j];
                else if (i < idx && j > jdx)
                    subMatrix[i][j-1] = matrix[i][j];
                else if (i > idx && j < jdx)
                    subMatrix[i-1][j] = matrix[i][j];
                else if (i > idx && j > jdx)
                    subMatrix[i-1][j-1] = matrix[i][j];
            }
        }
        return subMatrix;
    }
}