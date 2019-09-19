package L08_Classes_Intro_5.Task03;

public class Main {
    public static void main(String[] args) {
        var values = new JohnDoe(10, 15);
        values.print();
        System.out.println("The max is " + values.max());
        System.out.println("The sum is " + values.sum());
    }
}
