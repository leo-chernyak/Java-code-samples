/*
5) Создать класс “Monster” со строковой переменной для имени, целочисленной переменной для очков
здоровья, двумя вещественными переменными для силы атаки и показателя защиты. Добавить в класс
конструктор с параметрами и функцию для вывода всех параметров, на экран.
 */
package L09_Classes_Base_10.Task05;


public class Monster {
    public String name;
    int healthPoint;
    double force;
    double armor;
    Monster(String name, int healthPoint, double force, double armor){
        this.armor=armor;
        this.force = force;
        this.healthPoint = healthPoint;
        this.name = name;
    }

    public void print(){
        System.out.println(this);
    }

    public String toString() {return "Name: " + name + ", Health: " + healthPoint + ", force: " + force + ", armor: " + armor;}
}
