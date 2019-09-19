package L06_DoubleArray_9.T02_DownSort;

import L06_DoubleArray_9.Methods;

public class Main {
    public static void main(String[] args) {
        int [][] array = {
                {1, 3, 1, -1},
                {1, 3, 1, -1},
        };
        System.out.println("Array before sorting");
        Methods.print(array);
        System.out.println("Array after sorting");
        Methods.DownSort(array);
        Methods.print(array);
    }
}
