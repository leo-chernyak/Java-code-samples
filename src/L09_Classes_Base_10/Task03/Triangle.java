package L09_Classes_Base_10.Task03;

import java.util.Arrays;

public class Triangle {
    int a;
    int b;
    int c;
    Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int perimeter() { return a + b + c;}

    public double area() {
        double p = 0.5 * perimeter();
        return Math.sqrt(p * ( p - a) * (p - b) * (p - c));
    }

    public String type(){
        int [] array = new int[]{a,b,c};
        Arrays.sort(array);
        int h = array[2] * array[2];
        int k = array[1] * array[1];
        int l = array[0] * array[0];
        if (h == k + l)
            return "rectangular";
        else if (h < k + l)
            return "acuteAngle";
        else
            return "obtuse";
    }
}
