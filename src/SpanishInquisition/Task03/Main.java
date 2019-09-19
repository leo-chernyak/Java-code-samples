package SpanishInquisition.Task03;

/**
 * Задача 3. Дано предложение. Заменить группы пробелов одиночными, крайние пробелы удалить.
 * Все слова перевести в нижний регистр, первые буквы сделать заглавными.
 */

public class Main {
    public static void main(String[] args) {
        String str = "hEllo  woRds  ";
        System.out.println(str);
        str = toLowerCaseExceptFirstElement(str);
        str = deleteAllExcessSpace(str);
        System.out.println(str);
    }

    private static String toLowerCaseExceptFirstElement(String s) {
        return s.substring(0,1).toUpperCase() +  s.substring(1).toLowerCase();
    }

    public static String deleteAllExcessSpace(String string) {
        String result = "";
        string = string.replaceAll("  ", " ");
        for (int i = 0; i < string.length() - 1; i++) {
            if ( string.charAt(i) == ' ' && string.charAt(i + 1) == ' ') {
                continue;
            }
            else
                result = result + string.charAt(i);
        }
        return result;
    }
}