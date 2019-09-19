package L14_Generics_5;

public class Main {
    public static void main(String[] args) {
        {
            System.out.println("Task 01:");
            Test.task01(1);
            Test.task01(1.0);
            Test.task01("hello");
        }

        {
            System.out.println("\nTask 02:");
            System.out.println( Test.task02(false) );
            System.out.println( Test.task02(0) );
            System.out.println( Test.task02(0.0) );
            System.out.println( Test.task02("Hello") );
        }

        {
            System.out.println("\nTask 03:");
            System.out.println( Test.task03(1.0,1.0) );
        }

        {
            System.out.println("\nTask 04:");
            System.out.println( Test.task04("Hello") );
            System.out.println( Test.task04( 'c' ) );
        }

        {
            System.out.println("\nTask 05:");
            Test.task05( new Boolean[] {true,false,true} );
            Test.task05( new String[] {"01", "45", "qwe"} );
            Test.task05( new Integer[] {1,5,3,7} );
            Test.task05( new Double[] {0.0, 1.0, 10.0});
        }

        {
            System.out.println("\nTask 06:");
            Test.task06(new Elf());
            Test.<Elf>task06(new ElfMage());
            Test.<ElfArcher>task06(new ElfArcher());
            Test.task06(new ElfWarrior());
        }
    }
}