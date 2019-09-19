package L11_Classes_Inheritance_3_1.Task03.Orcs;

public class OrcGrunt extends Orc {
    public OrcGrunt(int damage, int armor, int health) {
        //crushing”, “hacking” и “magical”
        super(damage, armor, health, "crushing");
    }

    @Override
    public void Attack() {
        System.out.println(damage + " " + typeAttack);
    }
}
