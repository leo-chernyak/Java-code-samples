package L11_Classes_Inheritance_3_1.Task02;

import L11_Classes_Inheritance_3_1.Task02.Rodents.Chinchilla;
import L11_Classes_Inheritance_3_1.Task02.Rodents.Hamster;
import L11_Classes_Inheritance_3_1.Task02.Rodents.Rat;
import L11_Classes_Inheritance_3_1.Task02.Rodents.Rodent;

public class Main {
    public static void main(String[] args) {
        Rodent rodent1 = new Rat(true, 15, "Red", 15);
        Rodent rodent2 = new Hamster(true, 15, "Red", 20);
        Rodent rodent3 = new Chinchilla(true, 15, "Red", 30);
        rodent1.run();
        rodent2.run();
        rodent3.run();
    }
}
