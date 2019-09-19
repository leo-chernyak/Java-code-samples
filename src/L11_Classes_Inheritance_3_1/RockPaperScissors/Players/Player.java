package L11_Classes_Inheritance_3_1.RockPaperScissors.Players;

public interface Player {
    String getName();
    L11_Classes_Inheritance_3_1.RockPaperScissors.Choice getMove();
    void addPoint();
    int getPoint();
}
