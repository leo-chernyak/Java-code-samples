package SpanishInquisition.Task07;

/**
 * Задача 7. Создать класс с двумя переменными. Добавить функцию вывода на экран и функцию
 * изменения этих переменных. Добавить функцию, которая находит сумму значений этих
 * переменных, и функцию которая находит наибольшее значение из этих двух переменных.
 */

public class Main {
    public static void main(String[] args) {
        Numbers number = new Numbers(4, 3);
        number.show();
        number.setLhs(10);
        number.show();
        System.out.println("Max:"+number.max());
        System.out.println("Sum:"+number.sum());
    }
}

class Numbers {
    private int lhs;
    private int rhs;

    public void setLhs(int lhs) {
        this.lhs = lhs;
    }

    public void setRhs(int rhs) {
        this.rhs = rhs;
    }

    public Numbers(int lhs, int rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public int max() {
        return Integer.max(lhs, rhs);
    }

    public int sum() {
        return lhs + rhs;
    }


    public void show() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return lhs + " - " + rhs;
    }
}