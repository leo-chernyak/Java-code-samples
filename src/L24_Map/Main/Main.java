package L24_Map.Main;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Knight, Integer> knights = new TreeMap<>( Knight::compare );
        knights.put( new Knight(13, "Egor"),10);
        knights.put( new Knight(102, "Egor1"),12);
        knights.put( new Knight(9, "Egor2"),13);
        knights.forEach((knight, integer) -> System.out.println(knight + " " + integer));
    }
}
