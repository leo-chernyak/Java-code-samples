package L15_Recursions_10;

public class Main {
    public static void main(String[] args) {
        {
            System.out.println("Task 01:");
            System.out.println(Recursions.task01(10));
            Recursions.task011(10);
            System.out.println();
            System.out.println(Recursions.task012(10));
        }

        {
            System.out.println("\nTask 02:");
            Recursions.task02(5,0);
        }

        {
            System.out.println("\n\nTask 03:");
            int res = Recursions.task03(3, 5);
            System.out.println(res + " - " + Recursions.i);
        }

        {
            System.out.println("\nTask 04:");
            int res = Recursions.task04(123);
            System.out.println(res);
        }

        {
            System.out.println("\nTask 05:");
            Recursions.task05(123);
        }

        {
            System.out.println("\n\nTask 06:");
            Recursions.task06(123);
        }

        {
            System.out.println("\n\nTask 07:");
            Recursions.task07(123, 1);
            Recursions.task007(13, 1);
        }

        {
            System.out.println("\n\nTask 08:");
            String str = "123";
            System.out.println(str + " - " + Recursions.task08(str));
            str = "KAZAK";
            System.out.println(str + " - " + Recursions.task08(str));
        }

        {
            System.out.println("\n\nTask 09:");
            Recursions.task09();
        }

        {
            System.out.println("\n\nTask 10:");
            System.out.println(Recursions.task10());
        }

    }
}
