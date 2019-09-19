package L11_Classes_Inheritance_3_1.RockPaperScissors;

import L11_Classes_Inheritance_3_1.RockPaperScissors.Players.Player;

import java.util.Scanner;

public class Game {
    Player[] players = new Player[2];
    Game(Player first, Player second) {
        this.players[0] = first;
        this.players[1] = second;
    }
    public void play() {
        boolean isGame = true;
        while (isGame) {
            for (int i = 0; i < players.length; ++i) {
                players[i].getName();
            }

            System.out.println(fight());

            for (int i = 0; i < players.length; ++i) {
                System.out.println("Count point of " + players[i].getName() + " is " + players[i].getPoint());
            }

            System.out.print("For exit press n :");
            if (new Scanner(System.in).next() == "n") {
                System.out.println("Good buy");
                break;
            }
            System.out.println();
        }
    }
    private String fight() {
        Choice one = players[0].getMove();
        Choice two = players[1].getMove();
        if (one.getValue() == 1 && two.getValue() == 3) {
            players[0].addPoint();
            return "The winner is " + players[0].getName();
        }
        else if (one.getValue() > two.getValue()) {
            players[0].addPoint();
            return "The winner is " + players[0].getName();
        }
        else if (one.getValue() < two.getValue()) {
            players[1].addPoint();
            return "The winner is " + players[1].getName();
        }
        else return "No winner";
    }
}
