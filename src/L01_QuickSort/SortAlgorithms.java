package L01_QuickSort;

import java.util.Collections;
import java.util.List;

public class SortAlgorithms {
    public static void quickSort(List<String> data) {
        quickSort(data, 0, data.size()-1);
    }
    private static void quickSort(List<String> data, int left, int right) {
        int index = partition(data, left, right);
        if (left < index - 1)
            quickSort(data, left, index - 1);
        if (index < right)
            quickSort(data, index, right);
    }
    private  static  int  partition(List<String> data, int left, int right) {
        int i = left, j = right;
        int centrePos = (i + j) / 2;
        String pivot = data.get(centrePos).toLowerCase();
        while (i <= j) {
            while (data.get(i).toLowerCase().compareTo(pivot) < 0)
                i++;
            while (data.get(j).toLowerCase().compareTo(pivot) > 0)
                j--;
            if (i <= j) {
                Collections.swap(data, i, j);
                i++;
                j--;
            }
        }
        return i;
    }
}