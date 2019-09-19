package L08_Classes_Intro_5.Task01;

public class Human {
    String firstName = "";
    String secondName = "";
    boolean isMale = true;
    Human(){
        this("John", "Doe", true);
    }
    Human(String FirstName){
        this(FirstName, "Doe", true);
    }
    Human(String FirstName, String SecondName){
        this(FirstName, SecondName, true);
    }
    Human(String FirstName, String SecondName, boolean isMale){
        this.firstName = FirstName;
        this.secondName = SecondName;
        this.isMale = isMale;
    }
}
