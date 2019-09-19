package L26_FilesReadWrite.Task02;

/**
 * Задача 2. 12 графов и графинь танцуют вальс. Каждый такт они перемещаются по
 * танцевальному залу. Нужно создать классы граф и графиня в каждом из которых будет поля
 * “имя” и их координаты (х и у). Каждый такт танца они будут сдвигаться в случайном
 * направлении на единицу. После каждого “шага” нужно записывать их новое положение в binфайл(удаляя
 * при этом старое). В программе должно быть два режима. Первый это такты
 * танцев, который будет каждый раз спрашивать “еще такт?” до тех пор пока пользователь не
 * скажет остановиться. И второй режим, который считывает bin-файл и показывает на экране
 * координаты и имена каждого из танцующих.
 */

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        List names = getNamesFromFile("src/Task02/Names.txt");
        List dancers = generateDancersbyNames(names);
        dancers.forEach(System.out::println);
        dance(dancers);
        dancers.forEach(System.out::println);
        saveDataToFile("src/Task02/PositionOfDancers.bin", dancers);
        System.out.println("\n HEllo");
        readDataToFile("src/Task02/PositionOfDancers.bin");
    }

    private static void saveDataToFile(String path, List<Dancer> list) {
        try(DataOutputStream out = new DataOutputStream(new FileOutputStream(path))) {
            for (Dancer dancer : list) {
                out.writeUTF(dancer.count.name);
                out.writeUTF(dancer.count.sex);
                out.writeInt(dancer.count.x);
                out.writeInt(dancer.count.y);

                out.writeUTF(dancer.countless.name);
                out.writeUTF(dancer.countless.sex);
                out.writeInt(dancer.countless.x);
                out.writeInt(dancer.countless.y);
            }
        } catch (Exception ignored) {}
    }
    private static void readDataToFile(String path) {
        try(DataInputStream in = new DataInputStream(new FileInputStream(path))) {
            while ( true ) {
                {
                    // read count
                    String name = in.readUTF();
                    String sex = in.readUTF();
                    int x = in.readInt();
                    int y = in.readInt();
                    System.out.print(name + " " + sex + " " + x + " " + y + "    ");
                }
                {
                    // read countless
                    String name = in.readUTF();
                    String sex = in.readUTF();
                    int x = in.readInt();
                    int y = in.readInt();
                    System.out.println(name + " " + sex + " " + x + " " + y);
                }
            }
        }
        catch (EOFException ignored) { }
        catch (Exception ignored) { }
    }
    private static void dance(List<Dancer> dancers) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String choose;
            do {
                System.out.println("4 - Left, 8 - Up, 6 - right, 2 - down, 5 - exit");
                System.out.print("Choose: ");
                choose = reader.readLine();
                switch (choose) {
                    case "2":
                        dancers.forEach(Direction.DOWN::move);
                        break;
                    case "4":
                        dancers.forEach(dancer -> Direction.LEFT.move((Dancer) dancer));
                        break;
                    case "6":
                        dancers.forEach(dancer -> Direction.RIGHT.move((Dancer) dancer));
                        break;
                    case "8":
                        dancers.forEach(dancer -> Direction.UP.move((Dancer) dancer));
                        break;
                }
            } while ( !choose.equals("5") );
        } catch (IOException ignored) {}
    }
    private static List<Dancer> generateDancersbyNames(List names) {
        ArrayList<Dancer> dancers = new ArrayList<>();
        Random random = new Random();
        int size = names.size();
        for (int i = 0; i < 12; i++) {
            Dancer dancer;
            do {
                int x = random.nextInt(10);
                int y = random.nextInt(10);
                String nameCount = (String) names.get(random.nextInt(size));
                String nameCountless = (String) names.get(random.nextInt(size));
                Count count = new Count(nameCount, x, y);
                Countless countless = new Countless(nameCountless, x, y);
                dancer = new Dancer(count, countless);
            } while (dancers.contains(dancer));
            dancers.add(dancer);
        }
        return dancers;
    }
    private static List getNamesFromFile(String path) {
        StringBuilder names = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                names.append((char) ch);
            }
        } catch (IOException ignored) {}
        return new ArrayList(Arrays.asList(names.toString().split("\n")));
    }
}