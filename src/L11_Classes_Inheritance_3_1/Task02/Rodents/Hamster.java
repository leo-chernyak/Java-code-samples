package L11_Classes_Inheritance_3_1.Task02.Rodents;

public class Hamster extends  Rodent {
    public Hamster(boolean isMale, double weight, String color, double speedRun){
        super(isMale, weight, color, speedRun);
    }

    @Override
    public void run() {
        System.out.println(this.getClass().getSimpleName() + ". Speed is " + speedRun);
    }
}
