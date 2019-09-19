package L07_Arrays_34.From01To10;

import java.util.Arrays;

public class From01To10 {
    public static void main(String[] args) {
        int [] array1 = new int[] {5, 1, 1, 10, 15};
        int [][] array2 = new int[][] {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
        };
        System.out.println("01.Latin alphabet is " + Arrays.toString(Number01()));
        System.out.println("02.Maximum value from integer array " + Arrays.toString(array1) + " is " + Number02(array1));
        System.out.println("03.Minimum value from integer array " + Arrays.toString(array1) + " is " + Number03(array1));
        System.out.println("04.The sum of the elements following after item equal to one " + Arrays.toString(array1) + " is " + Number04(array1));
        System.out.println("05.The minimum element on the main diagonals " + Arrays.deepToString(array2) + " is " + Number05(array2));
        System.out.println("06.Three-dimensional matrix is:");
        print(Number06(3 ,3 ,3,1));
        System.out.println("07.Are all elements" + Arrays.toString(array1) + " the same ? " + Number07(array1));
        System.out.println("08.The sum of the positive elements " + Arrays.toString(array1) + " is " + Number08(array1));
        System.out.println("09.Do elements in the array " + Arrays.toString(array1) +" are arranged in ascending order? "  + Number09(array1));
        System.out.println("10.Three most big elements " + Arrays.toString(array1) +" are "  + Arrays.toString(Number10(array1)));
    }

    public static char[] Number01() {
        return new char[]{
                'A', 'B', 'C', 'D', 'E',
                'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y',
                'Z',
        };
    }

    public static int Number02(int [] array) {
        int max = array[0];
        for(var value : array) {
            if (max < value)
                max = value;
        }
        return max;
    }

    public static int Number03(int [] array) {
        int min = array[0];
        for(var value : array) {
            if (min > value)
                min = value;
        }
        return min;
    }

    public static int Number04(int [] array) {
        int res = 0;
        boolean state = false;
        for(var value : array) {
            if (state) {
                res += value;
                state = false;
            }
            if (value == 1)
                state = true;
        }
        return res;
    }

    public static int Number05(int [][] array) {
        int res = array[0][0];
        for(int i = 0; i < array.length; ++i) {
            if (res > array[i][i])
                res = array[i][i];
        }
        return res;
    }

    public static int [][][] Number06(int firts, int second, int third, int value) {
        int [][][] array = new int [firts][second][third];
        int i = 0;
        while (i < firts) {
            int j = 0;
            while (j < second){
                int z = 0;
                while (z < third) {
                    array[i][j][z] = value;
                    z++;
                }
                j++;
            }
            i++;
        }
        return array;
    }

    public static boolean Number07(int [] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i] != array[i + 1])
                return false;
        }
        return true;
    }

    public static int Number08(int [] array) {
        int res = 0;
        for(int i = 0; i < array.length; ++i) {
            res += array[i] >= 0 ? array[i] : 0;
        }
        return res;
    }

    public static boolean Number09(int [] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }

    public static int[] Number10(int [] array) {
        int [] buffer = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            buffer[i] = array[i];
        }
        for (int i = 0; i < buffer.length; ++i) {
            for (int j = 0; j < buffer.length - i - 1; ++j) {
                if (buffer[j] > buffer[j + 1])
                    swap(buffer, j, j + 1);
            }
        }
        int size = buffer.length - 1;
        return new int[]{buffer[size], buffer[size - 1], buffer[size - 2] };
    }

    public static void print(int[][][]array) {
        for (int i = 0; i < array.length; ++i) {
            print(array[i]);
            System.out.println();
        }
    }

    public static void print(int[][]array2) {
        for (var array1 : array2) {
            for (var value : array1) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void print(double[][]array2) {
        for (var array1 : array2) {
            for (var value : array1) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void swap(int [] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void swap(double [] array, int i, int j) {
        double tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}