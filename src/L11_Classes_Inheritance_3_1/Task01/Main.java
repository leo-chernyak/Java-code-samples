package L11_Classes_Inheritance_3_1.Task01;

import L11_Classes_Inheritance_3_1.Task01.Dogs.*;

public class Main {
    public static void main(String[] args) {
        Dog homeDog = new DomesticDog("Bobik", true, 25, "Sunset street 25");
        Dog domesticDog = new HomelessDog("", true, 15, "California");
        Dog serviceDog = new ServiceDog("Dog 25", true, 20, "Umbrella");
    }
}
