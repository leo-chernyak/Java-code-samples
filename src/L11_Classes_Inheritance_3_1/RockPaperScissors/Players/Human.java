package L11_Classes_Inheritance_3_1.RockPaperScissors.Players;

import java.util.Scanner;

public class Human implements Player {
    String name;
    int points = 0;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public L11_Classes_Inheritance_3_1.RockPaperScissors.Choice getMove() {
        System.out.println("Time for " + getName());
        System.out.print("Choose from Rock = 1, Paper = 2, Scissors = 3: ");
        return L11_Classes_Inheritance_3_1.RockPaperScissors.Choice.getCountry(new Scanner(System.in).nextInt() % 3);
    }

    @Override
    public void addPoint() {
        points++;
    }

    @Override
    public int getPoint() {
        return points;
    }
}
