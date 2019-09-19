package L11_Classes_Inheritance_3_1.Task03.Orcs;

public abstract class Orc {
    int damage;
    int armor;
    int health;
    String typeAttack;
    public Orc(int damage, int armor, int health, String typeAttack){
        this.damage = damage;
        this.armor = armor;
        this.health = health;
        this.typeAttack = typeAttack;
    }
    public abstract void Attack();
}