package L11_Classes_Inheritance_3_1.Task01.Dogs;

public class DomesticDog extends Dog {
    String address;
    public DomesticDog(String name, boolean isMale, double weight, String address) {
        super(name, isMale, weight);
        this.address = address;
    }

    public void voice() {
        System.out.println("The DomesticDog says: Hello baby"); }

    public void action() {
        System.out.println("The DomesticDog does: bite baby"); }

}
