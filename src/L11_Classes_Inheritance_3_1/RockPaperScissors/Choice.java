package L11_Classes_Inheritance_3_1.RockPaperScissors;

public enum Choice {
    Paper(1),
    Scissors(2),
    Rock(3);

    public static Choice getCountry(int i) {
        return Choice.values()[i];
    }
    int value;
    Choice(int x)
    {
        this.value = x;
    }
    public int getValue()
    {
        return value;
    }
}
