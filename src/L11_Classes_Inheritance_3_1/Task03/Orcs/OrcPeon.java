package L11_Classes_Inheritance_3_1.Task03.Orcs;

public class OrcPeon extends Orc{
    public OrcPeon(int damage, int armor, int health) {
        //crushing”, “hacking” и “magical”
        super(damage, armor, health, "hacking");
    }

    @Override
    public void Attack() {
        System.out.println(damage + " " + typeAttack);
    }
}
