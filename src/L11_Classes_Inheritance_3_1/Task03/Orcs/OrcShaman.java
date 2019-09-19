package L11_Classes_Inheritance_3_1.Task03.Orcs;

public class OrcShaman extends Orc {
    public OrcShaman(int damage, int armor, int health) {
        //crushing”, “hacking” и “magical”
        super(damage, armor, health, "magical");
    }

    @Override
    public void Attack() {
        System.out.println(damage + " " + typeAttack);
    }
}
