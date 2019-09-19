package L09_Classes_Base_10.Task02;

public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(0,1);
        Fraction f2 = new Fraction(1,-1);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println("+ " + f1.add(f2));
        System.out.println("- " + f1.subtract(f2));
        System.out.println("* " + f1.multiply(f2));
        System.out.println("/ " + f1.devide(f2));
    }
}
