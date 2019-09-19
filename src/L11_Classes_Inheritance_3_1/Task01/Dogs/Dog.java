package L11_Classes_Inheritance_3_1.Task01.Dogs;

public abstract class Dog {
    String name;
    Boolean isMale;
    double weight;
    Dog(String name, boolean isMale, double weight) {
        this.name = name;
        this.isMale = isMale;
        this.weight = weight;
    }
    public abstract void voice();
    public abstract void action();

}
