package L06_DoubleArray_9;

public class Methods {
    public static void print(int[][] arrays) {
        for (var array : arrays) {
            for (var value : array) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void RiseSort(int [] sums, int [] indxs) {
        boolean sorted = false;
        while(!sorted){
            sorted=true;
            for(int i=0; i<sums.length - 1; i++) {
                if (sums[i] > sums[i+1]) {
                    int temp = sums[i];
                    sums[i] = sums[i+1];
                    sums[i + 1] = temp;

                    temp = indxs[i];
                    indxs[i] = indxs[i+1];
                    indxs[i + 1] = temp;

                    sorted = false;
                }
            }
        }
    }

    public static void DownSort(int [] sums, int [] indxs) {
        boolean sorted = false;
        while(!sorted){
            sorted=true;
            for(int i=0; i<sums.length - 1; i++) {
                if (sums[i] < sums[i+1]) {
                    int temp = sums[i];
                    sums[i] = sums[i+1];
                    sums[i + 1] = temp;

                    temp = indxs[i];
                    indxs[i] = indxs[i+1];
                    indxs[i + 1] = temp;

                    sorted = false;
                }
            }
        }
    }

    public static void RiseSort(int [][] a) {
        boolean sorted = false;
        while(!sorted){
            sorted=true;
            int i=0, j=0;
            for(int icurr=0; icurr<a.length; icurr++) {
                for (int jcurr = 0; jcurr < a[i].length; jcurr++) {
                    if (a[i][j] > a[icurr][jcurr]) {
                        int temp = a[i][j];

                        a[i][j] = a[icurr][jcurr];
                        a[icurr][jcurr] = temp;
                        sorted = false;
                    }
                    i = icurr;
                    j = jcurr;
                }
            }
        }
    }

    public static void DownSort(int [][] a) {
        boolean sorted = false;
        while(!sorted){
            sorted=true;
            int i=0, j=0;
            for(int icurr=0; icurr<a.length; icurr++) {
                for (int jcurr = 0; jcurr < a[i].length; jcurr++) {
                    if (a[i][j] < a[icurr][jcurr]) {
                        int temp = a[i][j];

                        a[i][j] = a[icurr][jcurr];
                        a[icurr][jcurr] = temp;
                        sorted = false;
                    }
                    i = icurr;
                    j = jcurr;
                }
            }
        }
    }

}
