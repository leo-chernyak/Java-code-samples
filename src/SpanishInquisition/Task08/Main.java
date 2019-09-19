package SpanishInquisition.Task08;

import java.awt.*;

/**
 * Задача 8. Описать класс, представляющий треугольник. Предусмотреть методы для создания
 * объектов, вычисления площади, периметра и точки пересечения медиан.
 */

public class Main {
    public static void main(String[] args) {
        Point a = new Point(0,1);
        Point b = new Point(3,4);
        Point c = new Point(7,2);
        Treungle treungle = new Treungle(a,b,c);
        System.out.println(treungle.square());
        System.out.println(treungle.MedianPoint());
        System.out.println(treungle.perimeter());
    }
}

class Treungle {
    private Point a;
    private Point b;
    private Point c;

    public Treungle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private double distance(Point lhs, Point rhs) {
        return Math.sqrt((rhs.x - lhs.x)*(rhs.x - lhs.x) + (rhs.y - lhs.y)*(rhs.y - lhs.y));
    }

    public double perimeter() {
        double a1 = distance(a, c);
        double b1 = distance(a, b);
        double c1 = distance(b, c);
        return a1 + b1 + c1;
    }

    public double square() {
        double a1 = distance(a, c);
        double b1 = distance(a, b);
        double c1 = distance(b, c);
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - a1) * (p - b1) * (p - c1));
    }

    public Point MedianPoint() {
        return new Point( (a.x + b.x + c.x) / 3, (a.y + b.y + c.y) / 3 );
    }
}