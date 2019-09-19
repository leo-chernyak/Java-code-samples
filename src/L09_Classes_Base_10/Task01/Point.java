package L09_Classes_Base_10.Task01;

public class Point {
    private int x;
    private int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() { return x;}
    public int getY() { return y;}

    public double distance(Point point) {
        return Math.abs(Math.sqrt(Math.pow(point.x - x, 2) + Math.pow(point.y - y, 2)));
    }
}
