package L14_Generics_5;

import java.io.Serializable;
import java.util.Arrays;

public class Test<T> {
    public static <T> void task01(T value) {
        System.out.println(value.getClass().getSimpleName() + " value is " + value.toString());
    }

    public static <T> String task02(T value) {
        if ( value.equals(Boolean.FALSE) )
            return "Верно";
        else if ( value.equals(0) )
            return "Верно";
        return "Не верно";
    }

    public static <T extends Number> T task03(T lhs, T rhs) {
        if ( lhs instanceof Integer ) {
            Integer val = (Integer) lhs + (Integer) rhs;
            return (T) val;
        }
        if ( lhs instanceof Float ) {
            Float val = (Float) lhs + (Float) rhs;
            return (T) val;
        }
        if ( lhs instanceof Double ) {
            Double val = (Double) lhs + (Double) rhs;
            return (T) val;
        }
        return null;
    }

    public static <T extends Serializable> Character task04(T data) {
        if (data instanceof Character)
            return ((Character) data).charValue();

        if (data instanceof String)
        {
            char res = '\u0000';
            for (var ch : ((String) data).toCharArray())
                res += ch;
            return res;
        }
        return Character.MIN_VALUE;
    }

    public static <T extends Serializable> T [] task05(T [] array) {
        if (array instanceof Integer [])
        {
            Integer [] arrayClone = ((Integer [])array).clone();
            System.out.println(Arrays.toString(arrayClone));
            return (T []) arrayClone;
        }
        if (array instanceof Float [])
        {
            Float [] arrayClone = ((Float [])array).clone();
            System.out.println(Arrays.toString(arrayClone));

            return (T []) arrayClone;
        }
        if (array instanceof Boolean [])
        {
            Boolean [] arrayClone = ((Boolean [])array).clone();
            System.out.println(Arrays.toString(arrayClone));
            return (T []) arrayClone;
        }
        if (array instanceof Double [])
        {
            Double [] arrayClone = ((Double [])array).clone();
            System.out.println(Arrays.toString(arrayClone));
            return (T []) arrayClone;
        }
        if (array instanceof String [])
        {
            String [] arrayClone = ((String [])array).clone();
            System.out.println(Arrays.toString(arrayClone));
            return (T []) arrayClone;
        }
        return array;
    }

    public static <T extends Elf> void task06(T elf) {
        elf.Strike();
    }
}

class Elf {
    int damage = 0;
    int hp = 0;
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    void Strike() {
        System.out.println(toString() + " damage:" + damage);
    }
}

class ElfWarrior extends Elf { }
class ElfArcher extends Elf { }
class ElfMage extends Elf { }