package L09_Classes_Base_10.Task07;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Figure(10).type());
        System.out.println(new Figure(10, 10).type());
        System.out.println(new Figure(10, 10, 10).type());
        System.out.println(new Figure(-10, 10, 10).type());
    }
}
