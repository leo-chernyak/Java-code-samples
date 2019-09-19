package L11_Classes_Inheritance_3_1.Task02.Rodents;

public class Rat extends Rodent {
    public Rat(boolean isMale, double weight, String color, double speedRun){
        super(isMale, weight, color, speedRun);
    }

    @Override
    public void run() {
        System.out.println(this.getClass().getSimpleName() + ". Speed is " + speedRun);
    }
}
