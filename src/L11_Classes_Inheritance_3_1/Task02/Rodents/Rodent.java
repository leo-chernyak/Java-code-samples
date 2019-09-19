package L11_Classes_Inheritance_3_1.Task02.Rodents;

public abstract class Rodent {
    boolean isMale;
    double weight;
    String color;
    double speedRun;
    public Rodent(boolean isMale, double weight, String color, double speedRun){
        this.isMale = isMale;
        this.weight = weight;
        this.color = color;
        this.speedRun = speedRun;
    }
    public void run() {
        System.out.println("The rodent is running");
    }
    public void jump(){
        System.out.println("The rodent is jumping");
    }
    public void eat() { System.out.println("The rodent is eating"); }
}