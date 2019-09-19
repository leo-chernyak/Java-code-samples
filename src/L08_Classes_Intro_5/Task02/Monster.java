package L08_Classes_Intro_5.Task02;

public class Monster {
    String name = "";
    int healthPoint = 100;
    int armor = 50;
    int damage = 20;

    Monster(String name, int healthPoint, int armor, int damage) {
        this.name = name;
        this.healthPoint = healthPoint;
        this.armor = armor;
        this.damage = damage;
    }

    Monster(String name, int healthPoint, int armor) {
        this(name, healthPoint, armor, 20);
    }

    Monster(String name, int healthPoint) {
        this(name, healthPoint, 50, 20);
    }

    Monster(String name) {
        this(name, 100, 50, 20);
    }

    Monster() {
        this("John", 100, 50, 20);
    }
}
