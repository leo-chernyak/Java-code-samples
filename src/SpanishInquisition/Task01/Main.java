package SpanishInquisition.Task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Задача 1. Компьютер загадывает число от 1 до n. У пользователя k попыток отгадать. После каждой
 * неудачной попытки компьютер сообщает меньше или больше загаданное число. В конце игры текст
 * с результатом (или “Вы угадали”, или “Попытки закончились”).
 */

public class Main {
    public static void main(String[] args) throws IOException {
        int value = (int)(Math.random()*1000);
        int trys = 7;
        while (trys --> 0) {
            int playerChoice = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
            if ( playerChoice > value )
                System.out.println("Your number is higher than necessary");
            else if ( playerChoice < value )
                System.out.println("Your number is below than necessary");
            else {break;}
        }
        if (trys == -1)
            System.out.println("You lose");
        else System.out.println("You win");
        System.out.println(value);
    }

}