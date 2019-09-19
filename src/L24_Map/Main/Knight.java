package L24_Map.Main;

public class Knight implements Comparable<Knight> {
    int power = 0;
    String name;

    public Knight(int power, String name) {
        this.power = power;
        this.name = name;
    }


    @Override
    public int compareTo(Knight knight) {
        return this.power - knight.power;
    }

    static int compare(Knight lhs,  Knight rhs ) {
        return lhs.power - rhs.power;
    }

    @Override
    public String toString() {
        return name;
    }
}
