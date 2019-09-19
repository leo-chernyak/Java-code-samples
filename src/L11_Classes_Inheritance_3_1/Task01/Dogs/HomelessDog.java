package L11_Classes_Inheritance_3_1.Task01.Dogs;

public class HomelessDog extends Dog {
    String area;
    public HomelessDog(String name, boolean isMale, double weight, String area) {
        super(name, isMale, weight);
        this.area = area;
    }

    public void voice() {
        System.out.println("The HomelessDog says: Hello baby"); }

    public void action() {
        System.out.println("The HomelessDog does: bite baby"); }
}
