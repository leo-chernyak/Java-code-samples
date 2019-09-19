package L09_Classes_Base_10.Task04;

public class Human {
    public String name = "";
    public String surname = "";
    public int age = 0;
    public boolean isMale;
    Human(String name, String surname, int age, boolean isMale) {
        this.age = age;
        this.isMale = isMale;
        this.name = name;
        this.surname = surname;
    }
    Human(String name, String surname, int age) {
        this(name, surname, age, false);
    }

    Human(String name, String surname) {
        this(name, surname, -1, false);
    }

    Human(String name) {
        this(name, "", -1, false);
    }

    Human() {
        this("", "", -1, false);
    }
    @Override
    public String toString() {return "Name: " + name + ", Surname: " + surname + ", age: " + age + ", sex: " + (isMale ? "male" : "female");}
}
