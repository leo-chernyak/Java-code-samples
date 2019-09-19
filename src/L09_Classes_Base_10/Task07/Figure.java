package L09_Classes_Base_10.Task07;
/*
7) Создать класс “Figure” с тремя вещественными показателями для длины, ширины и высоты фигуры.
        Создать три конструктора, которые принимают от одного до трех указанных выше параметров для
        создания объектов класса, представляющих соответственно прямую, прямоугольник и параллелепипед.
        Добавить в класс функцию для вывода типа фигуры в соответствии с определенными в конструкторе
        параметрами.
*/
public class Figure {
    double length;
    double width;
    double height;
    Figure(double width, double height, double length) {
        this.height = height;
        this.length = length;
        this.width = width;
    }

    Figure(double width, double height) {
        this(width, height, 0);
    }

    Figure(double width) {
        this(width, 0, 0);
    }

    public String type() {
        if (length > 0 && height > 0 && width > 0)
            return "parallelepiped";
        else if (height > 0 && width > 0)
            return "rectangle";
        else if (width > 0)
            return "line";
        return "unidentified";
    }
}
