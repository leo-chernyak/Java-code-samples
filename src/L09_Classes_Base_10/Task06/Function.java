package L09_Classes_Base_10.Task06;

/*
Создать класс ”Function” c четырьмя вещественными показателями для коэффициентов при каждом
члене в формуле x3+x2+x+c, также создать функцию, принимающую на вход показатель x и выводящую
значение функции в соответствующей x точке. Добавить в класс конструктор с параметрами, функцию для
вывода формулы с добавленными в нее параметрами.
 */
public class Function {
    double x1;
    double x2;
    double x3;
    double c;
    Function(double x1, double x2, double x3, double c) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.c = c;
    }
    public double calculate(double x) {
        return x1 * Math.pow(x, 3) + x2 * x * x + x3 * x  + c;
    }
}
