package SpanishInquisition.Task11;

import java.io.*;
import java.util.*;

/**
 * Задача (^-^). Построить три класса (базовый и 3 потомка), описывающих некоторых хищных животных
 * (один из потомков), всеядных(второй потомок) и травоядных (третий потомок). Описать в базовом классе
 * абстрактный метод для расчета количества и типа пищи, необходимого для пропитания животного в
 * зоопарке.
 * a) Упорядочить всю последовательность животных по убыванию количества пищи. При совпадении
 * значений – упорядочивать данные по алфавиту по имени. Вывести идентификатор животного, имя, тип и
 * количество потребляемой пищи для всех элементов списка.
 * b) Вывести первые 5 имен животных из полученного в пункте а) списка.
 * c) Вывести последние 3 идентификатора животных из полученного в пункте а) списка.
 * d) Организовать запись и чтение коллекции в/из файл.
 * e) Организовать обработку некорректного формата входного файла.
 */

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var animals = createAnimals();
        animals.sort(Comparator.comparingInt(Animal::getCountFood));
        for (int i = 0; i < 3; i++) {
            System.out.println(animals.get(i));
        }
        for (int i = animals.size()-3; i < animals.size(); i++) {
            System.out.println(animals.get(i));
        }
        saveToFile("Animals", animals);
        animals.clear();
        System.out.println("\nCount animals after save into file: " + animals.size());
        animals = readFromFile("Animals");
        System.out.println("Animals after reading:\n");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public static ArrayList<Animal> createAnimals() {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Predaror("Kivi", 500));
        animals.add(new Predaror("Dallas", 300));
        animals.add(new Predaror("Shampayn", 600));

        animals.add(new Herbivorous("Rosa", 1500));
        animals.add(new Herbivorous("Fialka", 1200));
        animals.add(new Herbivorous("Fialka2", 1300));

        animals.add(new Omnivorous("Fialkov1", 800));
        animals.add(new Omnivorous("Fialkov2", 900));
        animals.add(new Omnivorous("Fialkov3", 700));
        animals.add(new Omnivorous("Fialkov4", 1000));
        return animals;
    }

    public static void saveToFile(String filePath, ArrayList<Animal> animals) throws IOException {
        ObjectOutputStream s = new ObjectOutputStream(new FileOutputStream(filePath));
        s.writeInt(animals.size());
        for (var animal : animals) {
            s.writeObject(animal);
        }
        s.flush();
        s.close();
    }

    public static ArrayList<Animal> readFromFile(String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream s = new ObjectInputStream(new FileInputStream(filePath));
        int size = s.readInt();
        ArrayList<Animal> animals = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Animal p = (Animal) s.readObject();
            animals.add(p);
        }
        s.close();
        return animals;
    }
}

enum Food {
    GRASS,
    MEAT,
    ALL;
}

abstract class Animal implements Serializable {
    private String name;
    protected Food food;
    private int countFood;

    public int getCountFood() {
        return countFood;
    }

    public Animal(String name, Food food, int countFood) {
        this.name = name;
        this.food = food;
        this.countFood = countFood;
    }

    abstract Map.Entry<Food, Integer> countMeel();

    @Override
    public String toString() {
        return getClass().getSimpleName() + ", name is " +  name + ", type of food: " + food + ", exist food: " + countFood;
    }

    public int compareTo(Animal animal) {
        return (this.name.compareTo(animal.name));
    }
}

class Predaror extends Animal {

    public Predaror(String name, int countFood) {
        super(name, Food.MEAT, countFood);
    }

    @Override
    Map.Entry<Food, Integer> countMeel() {
        return new AbstractMap.SimpleEntry<>(food, 100);
    }
}

class Herbivorous extends Animal {
    public Herbivorous(String name, int countFood) {
        super(name, Food.GRASS, countFood);
    }

    @Override
    Map.Entry<Food, Integer> countMeel() {
        return new AbstractMap.SimpleEntry<>(food, 100);
    }
}

class Omnivorous extends Animal {
    public Omnivorous(String name, int countFood) {
        super(name, Food.ALL, countFood);
    }

    @Override
    Map.Entry<Food, Integer> countMeel() {
        return new AbstractMap.SimpleEntry<>(food, 100);
    }
}



