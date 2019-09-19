package L24_Map.Task02;

import java.util.Random;

public class Human {
    static Random random = new Random();
    private int health = 0;
    final String name;
    private boolean isALive = true;

    public Human(String name, int health) {
        this.health = health;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void downHealth(int health) {
        if ( this.health - health <= 0 ) {
            this.health = 0;
            isALive = false;
        }
        this.health -= health;
    }

    public boolean isALive() {
        return isALive;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "\t\t" + name + "\t\t" + health + "\t\t" + isALive;
    }
}