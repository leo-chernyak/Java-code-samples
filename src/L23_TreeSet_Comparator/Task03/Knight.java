package L23_TreeSet_Comparator.Task03;

import java.util.Random;

public class Knight implements Comparable<Knight> {
    final String name;
    int health;
    int armor;
    int damage;
    public Knight(String name, int health, int armor, int damage) {
        this.name = name;
        this.health = health;
        this.armor = armor;
        this.damage = damage;
    }

    @Override
    public int compareTo(Knight knight) {
        if (this.equals(knight)) return 0;
        Random random = new Random();
        int attacks = 0;
        while ( this.health > 0 && knight.health > 0 ) {
            if ( random.nextBoolean() == true) fight(this, knight);
            else fight(knight, this);
            if (++attacks > 100)
                break;
        }
        return health - knight.health;
    }

    private static void fight(Knight lhs, Knight rhs) {
        int attack = lhs.damage - rhs.armor > 0 ? lhs.damage - rhs.armor : 0;
        rhs.health -= attack;
    }

    @Override
    public String toString() { return String.format("%-10s %4s %4s %4s", name, health, damage, armor); }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((Knight)obj).name);
    }
}