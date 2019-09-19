package L08_Classes_Intro_5.Task03;

public class JohnDoe {
    int firstValue = 0;
    int secondValue = 0;
    JohnDoe(int firstValue, int secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    JohnDoe(int firstValue) {
        this(firstValue, 0);
    }

    JohnDoe() {
        this(0, 0);
    }

    public void print() {
        print("\n");
    }

    private void print(String str) {
        System.out.print("First value is " + firstValue + ", and second value is " + secondValue + str);
    }

    public void setFirstValue(int value) {this.firstValue = value;}
    public void setSecondValue(int value) {this.secondValue = value;}

    public int sum() {
        return secondValue + firstValue;
    }

    public int max() {
        if (secondValue > firstValue)
            return secondValue;
        return firstValue;
    }
}
