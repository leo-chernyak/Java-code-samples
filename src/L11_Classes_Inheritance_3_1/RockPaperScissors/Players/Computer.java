package L11_Classes_Inheritance_3_1.RockPaperScissors.Players;

public class Computer implements Player {
    int points = 0;

    @Override
    public String getName() {
        return "Computer";
    }

    @Override
    public L11_Classes_Inheritance_3_1.RockPaperScissors.Choice getMove() {
        System.out.println("The " + getName() + " made decision");
        return L11_Classes_Inheritance_3_1.RockPaperScissors.Choice.getCountry((int)(Math.random()*3));
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
