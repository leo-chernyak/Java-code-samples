package L20_TaskForPractice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        //int max = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        //new SimplePythagoreanTriples(max).showNumbers();
        //new LiveStock().showHowBuy(100, 100);
//        new Ulamatablecloth().show();
//        Kordemskiy.show();
//        System.out.println();
//        PerfectNumbers.show();
        SameSquares.show(10_000);
    }
}

class SimplePythagoreanTriples {
    private int max = 0;
    public SimplePythagoreanTriples(int max) {
        this.max = max;
    }

    public void showNumbers() {
        for (int i = 1; i < max; i++) {
            for (int j = i + 1; j < max; j+= i % 2 != 0 ? 2 : 1) {
                if ( nod(i, j) != 1 ) continue;
                int a = j*j - i*i; //
                int b = 2*i*j;
                int c = j*j + i*i;
                if ( c > max ) continue;
                System.out.println(a + " - " + b + " - " + c);
            }
        }
    }

    private static int nod(int a, int b) {
        while(a > 0 && b > 0)
            if(a > b)
                a %= b;
            else
                b %= a;
        return a + b;
    }

}

class LiveStock {
    private int bullPrice = 10;
    private int cowPrice = 5;
    private double calfPrice = 0.5;
    public void showHowBuy(int count, int money) {
        for (int i = 0; i <= count / bullPrice; i++) {
            for (int j = 0; j <= count / cowPrice; j++) {
                for (int k = 0; k <= count / calfPrice; k++) {
                    if ( i  + j  + k  == count && i * bullPrice  + j * cowPrice  + k * calfPrice == money) {
                        System.out.println("Bulls: "+ i + " Cows: " + j + " Calfs: " + k);
                    }
                }
            }
        }
    }
}

class Ulamatablecloth {
    private int[][] Mas = new int[100][100];
    private int x = Mas.length / 2;
    private int y = Mas.length / 2;
    public Ulamatablecloth() {
    }

    public Ulamatablecloth(int x, int y) {
        this.x = x - 1;
        this.y = y - 1;
    }

    private boolean isSimple(int value) {
        for (int i = 2; i < value; i++) {
            if ( value % i == 0)
                return false;
        }
        return true;
    }

    private void calculate() {
        int value = 1;
        int countStep = Mas.length * Mas[0].length;
        int right = 1;
        int up = 1;
        int left = 2;
        int down = 2;
        while (countStep > 0) {
            for (int i = 0; i < right; i++) {
                try {
                    Mas[y][x] = value;
                    countStep--;
                } catch (ArrayIndexOutOfBoundsException ex) { }
                x++;
                value++;
            }

            for (int i = 0; i < up; i++) {
                try {
                    Mas[y][x] = value;
                    countStep--;
                } catch (ArrayIndexOutOfBoundsException ex) { }
                y--;
                value++;
            }
            for (int i = 0; i < left; i++) {
                try {
                    Mas[y][x] = value;
                    countStep--;
                } catch (ArrayIndexOutOfBoundsException ex) {}
                x--;
                value++;
            }
            for (int i = 0; i < down; i++) {
                try {
                    Mas[y][x] = value;
                    countStep--;
                } catch (ArrayIndexOutOfBoundsException ex) {}
                y++;
                value++;
            }
            up    += 2;
            left  += 2;
            down  += 2;
            right += 2;
        }
    }

    public void show() {
        calculate();
        for (int i = 0; i < Mas.length; i++) {
            for (int j = 0; j < Mas[i].length; j++) {
                if (isSimple(Mas[i][j])) {
//                    System.out.printf("\u001B[31m%03d \u001B[0m", Mas[i][j]);
                    System.out.print("*");
                }
                else {
//                    System.out.printf("%03d ", Mas[i][j]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

class Kordemskiy {

    public static void show() {
        for (int i = 0; i < 100_000; i++) {
            if (getRes(i) == i) System.out.println(i);
        }
    }

    private static int getRes(int value) {
        int res = 0;
        while ( value != 0 ) {
            res += fact(value % 10);
            value /= 10;
        }
        return res;
    }

    private static int ProdTree(int l, int r) {
        if (l > r)
            return 1;
        if (l == r)
            return l;
        if (r - l == 1)
            return (int)l * r;
        int m = (l + r) / 2;
        return ProdTree(l, m) * ProdTree(m + 1, r);
    }

    private static int fact(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (n == 1 || n == 2) return n;
        return ProdTree(2, n);
    }
}

class PerfectNumbers {
    private static int x = 1000;

    public static void show() {
        for (int i = 2; i < x; i++) {
            int v = (int)Math.pow(2, i) - 1;
            if ( isSimple(v) ) { {
                long res = (long)Math.pow(2,i-1) * v;
                System.out.println(res);
            }
            }
        }
    }

    private static boolean isSimple(int v) {
        for (int i = 2; i < v; i++) {
            if ( v % i == 0) return false;
        }
        return true;
    }
}

class Triangle {
    private int a;
    private int b;
    private int c;
    private double s;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.s = a * b / 2.;
    }

    public double getS() {
        return s;
    }

    @Override
    public String toString() {
        return a + " " + b + " " + c + " " + s;
    }

    @Override
    public boolean equals(Object obj) {
        return this.s == ((Triangle)obj).getS();
    }
}

class SameSquares {
    private static ArrayList<Triangle> triangles = new ArrayList<>();

    public static void show(int maxSquare) {
        caculating(maxSquare);
        triangles.sort(Comparator.comparing(Triangle::getS));
        for (int i = 0; i < triangles.size() - 1; i++)
        {
            if ( i!= triangles.size()-1 && triangles.get(i).equals(triangles.get(i + 1))) {
                System.out.println(triangles.get(i));
                System.out.println(triangles.get(i + 1));
                i++;
            }
            else if ( i != 0 && triangles.get(i).equals(triangles.get(i - 1)))
                System.out.println(triangles.get(i));
        }
    }

    private static void caculating(int maxSquare) {
        for (int i = 1; i < 2 * maxSquare - 1; i++) {
            for (int j = i; j < 2 * maxSquare - 1; j++) {
                double c = Math.sqrt(i*i+j*j);
                if ( (c - (int)c) == 0) {
                    if ( (i * j) / 2 <= maxSquare)
                        triangles.add(new Triangle(i, j, (int)c));
                }
            }

        }
    }

}