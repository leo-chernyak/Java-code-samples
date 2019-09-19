package L24_Map.Task01;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Задача 1. Рыцарский турнир закончился! Пришла пора объявить победителей. Но безответственный
 * клерк перепутал имена участников и теперь не может составить их правильный список. Нужно ему
 * помочь. А именно, используя treeMap создать список участников с полями “Честь” и соответствующее
 * ему “Имя рыцаря” и показать отсортированный список. Помним, чем больше чести, тем ближе к
 * верхушке турнирной таблицы.
 */

public class Main {
    public static void main(String[] args) {
        Random random = new Random();



        TreeMap<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(random.nextInt(50), "knight_" + i);
        }
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
