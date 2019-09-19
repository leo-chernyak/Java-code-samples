package L16_Exceptions_4;

import java.io.IOException;
import java.util.Scanner;

public class Solutions {

    /**
     *      Задача 1. Написать программу, которая будет считать значение функции f(x) = 1 / x при заданных
     *      значениях. Программа может принимать на вход любые значения отличные от нуля. Поймать в ней
     *      случай деления на ноль с помощью exeption’ов так, чтобы программа не завершала свою работу.
     */
    public static double task01 (int x) {
        double res = 0;
        try {
            if ( x == 0)
                //throw  new IllegalArgumentException("Bad choose");
            res = 1 / x;
        }
        catch (IllegalArgumentException ex) {
            System.out.print(ex.getMessage() + ". ");
        }
        catch (Exception ex) {
            System.out.print("All is bad. ");
        }
        finally {
            return res;
        }
    }

    /**
     *           Задача 2. Написать программу, которая будет считать значение функции f(x) = 12*x + 44 на
     *       промежутке [-71; 14]. Значение при котором нужно посчитать значение функции вводится с
     *       клавиатуры. Если оно не входит в заданный промежуток - бросается исключение. Программа при
     *       этом не должна завершать своей работы.
     */
    public static double task02 (int lhs, int rhs) {
        double res = 0;
        try {
            if ( lhs < -71 || lhs > 14 || rhs < -71 || rhs > 14)
                throw new IllegalArgumentException("Bad arguments. ");
            res = 12 * lhs + rhs;
        }
        catch (IllegalArgumentException ex) {
            System.out.print(ex.getMessage());
        }
        finally {
            return res;
        }
    }

    /**
     *      Задача 3. Написать программу, которая будет считать
     *      значение функции f(x) = 18*x ^ 2 + (54/x) - 8 на заданном
     *      промежутке ( промежуток вводится с клавиатуры ). Далее
     *      вводится с клавиатуры значение при котором нужно посчитать
     *      функцию. Если значение не входит в заданный промежуток -
     *      бросается исключение. Программа при этом не должна
     *      завершать своей работы.
     */
    public static double task03 (int lhs, int rhs, int x) {
        double res = 0;
        try {
            if ( x < lhs || x > rhs)
                throw new IllegalArgumentException("Bad arguments. ");
            res = 18 * x * x + 54.0 / x - 8;
        }
        catch (IllegalArgumentException ex) {
            System.out.print(ex.getMessage());
        }
        finally {
            return res;
        }
    }


    /**
     *      Задача 4. Модифицировать игру “Крустики нолики”
     *       так, чтобы была проверка на ввод данных. Если данные
     *       введены неверно - должно бросаться исключение. Программа
     *       при этом продолжает работу.
     */
    public static String task04 () {
        char [][] board = {
                {'\u0000','\u0000','\u0000'},
                {'\u0000','\u0000','\u0000'},
                {'\u0000','\u0000','\u0000'},
        };
        String res = "no winners";

        boolean isX = true;

        try {
            do {
                printBoard(board);

                System.out.print("Введите данные позицию: ");
                int pos = new Scanner(System.in).nextInt();

                if (pos < 11 || pos > 33)
                    throw new IOException("Значения за рамками массива. ");

                if (!isEmpty(board, pos))
                    throw new IllegalArgumentException("Место уже занято. ");

                if (isX) setCh(board, pos, 'X');
                else setCh(board, pos, 'O');
                isX = !isX;

                if ( checkWinner(board) != -1 ) {
                    res =  checkWinner(board) == 1 ? "X" : "O";
                    break;
                }

            } while ( isCanGo(board) );
        }
        catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        finally {
            return res;
        }
    }

    private static void printBoard(char [][] array) {
        for (int i = 1; i < 4; i++) {
            System.out.print( " " + i );
        }

        System.out.println();

        for (int i = 0; i < 7; i++) {
            System.out.print("-");
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (char ch : array[i]) {
                if (ch == '\u0000')
                    System.out.print("| ");
                else System.out.print("|" + ch);
            }
            System.out.println("| " + (i+1));
            for (int j = 0; j < 7; j++) {
                System.out.print("-");
            }
        }

        System.out.println();
    }

    private static int checkWinner(char [][] array) {

        for (int i = 0; i < array.length; i++)
        {
            char horizontal = '\u0000';
            char vertical = '\u0000';
            char mainDiaonal = '\u0000';
            char minorDiagonal = '\u0000';
            for (int j = 0; j < array[i].length; j++) {
                horizontal += array[i][j];
                vertical += array[j][i];
                mainDiaonal += array[j][j];
                minorDiagonal += array[j][array.length - 1 - j];
            }
            if (horizontal / 3 == 'X' || vertical / 3 == 'X' || mainDiaonal / 3 == 'X' || minorDiagonal / 3 == 'X')
                return 1;
            if (horizontal / 3 == 'O' || vertical / 3 == 'O' || mainDiaonal / 3 == 'O' || minorDiagonal / 3 == 'O')
                return 0;
        }
        return -1;
    }

    private static boolean isCanGo(char [][] chars) {
        for (char[] aChar : chars) {
            for (char c : aChar) {
                if (c == '\u0000')
                    return true;
            }
        }
        return false;
    }

    private static boolean isEmpty(char [][] chars, int pos) {
        return chars[pos % 10 - 1][pos / 10 - 1] == '\u0000';
    }

    private static void setCh(char [][] chars, int pos, char ch) {
        chars[pos % 10 - 1][pos / 10 - 1] = ch;
    }

    /**
     * Create a Exception class
     */
    public static void task05() {
        System.out.println("\nUsing our exception:");
        boolean isIHatePeople = true;
        try {
            if ( isIHatePeople )
                throw new GodPunishment("All people mast die");
            throw new GodPunishment();
        }
        catch (GodPunishment ex) {
            System.out.println(ex.getMessage());
        }
    }
}