package L23_TreeSet_Comparator.Task02;

public class Wizard implements Comparable<Wizard> {
    final String name;
    int health;
    int mana;

    public Wizard(String name, int health, int mana) {
        this.name = name;
        this.health = health;
        this.mana = mana;
    }

    @Override
    public int compareTo(Wizard wizard) {
        return mana-wizard.mana;
    }

    @Override
    public String toString() {
        return name + ' ' + health + " " + mana;
    }
}
