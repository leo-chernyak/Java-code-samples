package L09_Classes_Base_10.Task03;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(1,2,3);
        System.out.println("The perimeter is " + triangle.perimeter());
        System.out.println("The area is " + triangle.area());
        System.out.println("The type is " + triangle.type());

    }
}
