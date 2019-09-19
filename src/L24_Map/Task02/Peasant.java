package L24_Map.Task02;

public class Peasant extends Human {
    public Peasant(String name) {
        super(name, random.nextInt(25) + 25);
    }
}
