package L11_Classes_Inheritance_3_1.RockPaperScissors;

import L11_Classes_Inheritance_3_1.RockPaperScissors.Players.Computer;
import L11_Classes_Inheritance_3_1.RockPaperScissors.Players.Human;
import L11_Classes_Inheritance_3_1.RockPaperScissors.Players.Player;

public class RockPaperScissors {
    public static void main(String[] args) {
        Player player1 = new Human("Nikita");
        Player player2 = new Computer();
        new Game(player1, player2).play();
    }
}
