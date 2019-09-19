package L07_Arrays_34.From21To30;

import L07_Arrays_34.From01To10.From01To10;

import java.util.Arrays;

import static L07_Arrays_34.From11To20.From10To20.Number20;

public class From21To30 {

    public static void main(String[] args) {
        int [][] array2 = new int[][] {
                {1, 2, 3},
                {1, -7, 3},
                {1, 2, 3},
        };
        double [][] array2d = new double[][] {
                {1, 2, 3},
                {1, -11, 3},
                {1, 2, 3},
        };
        int [][][] array3 = new int[][][] {
                {
                        {-1, 2, 1},
                        {3, 4, 1},
                },
                {
                        {1, 2, 1},
                        {1, 2, 1},
                },
                {
                        {4, 2, 1},
                        {4, 4, 1},
                },
        };
        System.out.println("21.The average of a two-dimensional array " + Arrays.deepToString(array2) + " is " + Number21(array2));
        System.out.println("22.The sum of the elements on the main and secondary diagonals " + Arrays.deepToString(array2) + " is " + Number22(array2));

        System.out.println("23.Before normalize all items ");
        From01To10.print(array2d);
        Number23(array2d);
        System.out.println("After  normalize all items");
        From01To10.print(array2d);

        System.out.println("24.Before divide by 2 ");
        From01To10.print(array2d);
        Number24(array2d);
        System.out.println("After  divide by 2");
        From01To10.print(array2d);

        System.out.println("25.The sum of three-dimensional array elements is " + Number25(array3));

        System.out.println("26.Change sign for all negative elements " + Number25(array3));
        System.out.println("Before");
        From01To10.print(array3);
        System.out.println("After");
        Number26(array3);
        From01To10.print(array3);
        System.out.println("27.Calculate the arithmetic average for all non-negative elements " + Number27(array3));

        System.out.println("28.Sort ascending elements of a three-dimensional array ");
        System.out.println("Before");
        From01To10.print(array3);
        System.out.println("After");
        Number28(array3);
        From01To10.print(array3);

        System.out.println("29.Sort by increase of xy-plane of three-dimensional array by sum elements in them ");
        System.out.println("Before");
        From01To10.print(array3);
        System.out.println("After");
        Number29(array3);
        From01To10.print(array3);

        System.out.println("30.Output elements of a three-dimensional array ");
        Number30(array3);
    }

    public static double Number21(int[][]array) {
        return (double) Number20(array) / (array.length * array[0].length);
    }

    public static int Number22(int[][]array) {
        int sum = 0;
        for (int i = 0; i < array.length; ++i) {
            sum += array[i][i] + array[i][ array.length - 1 - i];
        }
        return sum;
    }

    public static void Number23(double[][]array) {
        double max = 0;
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {
                if (Math.abs(max) <  Math.abs(array[i][j]))
                    max = array[i][j];
            }
        }
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {
                array[i][j] /= max;
            }
        }
    }

    public static void Number24(double[][]array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {
                if (Math.abs(array[i][j]) > 10)
                    array[i][j] /= 2;
            }
        }
    }

    public static int Number25(int[][][]array) {
        int sum = 0;
        for (int i = 0; i < array.length; ++i) {
            sum += Number20(array[i]);
        }
        return sum;
    }

    public static void Number26(int[][][]array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {
                for (int z = 0; z < array[i][j].length; ++z) {
                    if (array[i][j][z] < 0)
                        array[i][j][z] *= -1;
                }
            }
        }
    }

    public static double Number27(int[][][]array) {
        int count = 0;
        int sums = 0;
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {
                for (int z = 0; z < array[i][j].length; ++z) {
                    if (array[i][j][z] >= 0)
                    {
                        sums += array[i][j][z];

                    }
                }
                count += array[i][j].length;
            }
        }
        return (double)sums/count;
    }

    public static void Number28(int[][][]array) {
        boolean sorted = false;
        while (!sorted)
        {
            sorted = true;
            int id = 0;
            int jd = 0;
            int zd = 0;
            for (int i = 0; i < array.length; ++i) {
                for (int j = 0; j < array[i].length; ++j) {
                    for (int z = 0; z < array[i][j].length; ++z) {
                        if (array[i][j][z] < array[id][jd][zd])
                        {
                            int tmp = array[i][j][z];
                            array[i][j][z] = array[id][jd][zd];
                            array[id][jd][zd] = tmp;
                            sorted = false;
                        }
                        id = i; jd = j; zd = z;
                    }
                }
            }
        }
    }

    public static int Number29(int[][][]array) {
        int sorts = 0;
        boolean sorted = false;
        while (!sorted)
        {
            sorted = true;
            int id = 0;
            for (int i = 0; i < array.length - 1; ++i) {
                if (Number20(array[i]) > Number20(array[i + 1]))
                {
                    swap(array, i, i +1);
                    sorted = false;
                    sorts++;
                }
                id = i;
            }
        }
        return sorts;
    }

    public static void Number30(int[][][]array3) {
        for (var array2 : array3) {
            for (var array : array2) {
                for (var value : array) {
                    System.out.print(value + " ");
                }
            }
        }
    }

    public static void swap(int[][][]array3, int id, int jd) {
        for (int i = 0; i < array3[id].length; ++i) {
            for (int j = 0; j < array3[id][i].length; ++j) {
                int tmp = array3[id][i][j];
                array3[id][i][j] = array3[jd][i][j];
                array3[jd][i][j] = tmp;
            }
        }
    }

}