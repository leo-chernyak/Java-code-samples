package L22_HashMap;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMapList<Integer, Integer> map = new HashMapList<>();
        map.put(1, 1);
        map.put(1, 1);
        map.put(1, 1);
        map.put(1, 1);
        map.put(1, 1);

        System.out.println(map.size());

        for (Map.Entry<Integer, ArrayList<Integer>> entry : map) {
            System.out.print(entry.getKey() + ": ");
            for (Integer i : entry.getValue()) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
   }
}