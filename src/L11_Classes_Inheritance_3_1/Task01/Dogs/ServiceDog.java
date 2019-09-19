package L11_Classes_Inheritance_3_1.Task01.Dogs;

public class ServiceDog extends Dog {
    String organization;
    public ServiceDog(String name, boolean isMale, double weight, String organization) {
        super(name, isMale, weight);
        this.organization = organization;
    }

    public void voice() {
        System.out.println("The ServiceDog says: Hello baby"); }

    public void action() {
        System.out.println("The ServiceDog does: bite baby"); }
}
