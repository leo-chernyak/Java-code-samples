package L23_TreeSet_Comparator.Task01;

public class Warrior implements Comparable<Warrior> {
    final String name;
    int health;
    int damage;

    public Warrior(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    @Override
    public int compareTo(Warrior warrior) {
        return this.damage - warrior.damage;
    }

    @Override
    public String toString() {
        return name + " " + health + " " + damage;
    }
}