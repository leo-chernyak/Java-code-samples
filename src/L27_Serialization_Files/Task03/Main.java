package L27_Serialization_Files.Task03;

import java.io.FileNotFoundException;

/**
 * Задача 3. Создать программу для работы с каталогами. На вход указать путь из которого начать. В
 * программе должны быть функции показать список файлов и папок в текущей директории,
 * создать/удалить каталог, вывести файлы определенного расширения.
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileUtils fileUtils = new FileUtils("/home/nlws/Desktop");
        fileUtils.pwd();
        System.out.println();

        fileUtils.ls("pdf");


        System.out.print("\nAdded: ");
        System.out.println(fileUtils.mkdir("Hello"));
        fileUtils.ls();


        System.out.print("\nDeleted: ");
        System.out.println(fileUtils.rm("Hello"));
        fileUtils.ls();
    }
}