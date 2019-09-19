package L09_Classes_Base_10.Task04;

public class Main {
    public static void main(String [] args) {
        System.out.println(new Human());
        System.out.println(new Human("John"));
        System.out.println(new Human("John", "Doe"));
        System.out.println(new Human("John", "Doe", 10));
        System.out.println(new Human("John", "Doe", 10, true));
    }
}
