package L30_Threads_Files.Task02;

import L30_Threads_Files.Task01.CommonResources;
import L30_Threads_Files.Task01.ThreadChanger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Задача 2. Расширить задачу 1. В общедоступный ресурс массив строк будет загружаться из
 * файла. Создать дополнительный класс или расширить имеющийся для работы с потоками,
 * который должен будет брать строку и менять символы обратно, с учётом сдвига(из BDDEEB
 * получаем ABBCCA).
 * Программа должна считать текст из файла, в многопоточном режиме обработать все строки,
 * через каждые 10 изменений сохранять все данные в новый файл. Главный поток должен
 * дождаться завершения этих потоков, считать финальную версию файла и в многопоточном
 * режиме преобразовать в исходный текст. Результат преобразования сохранить в файл.
 * *После выполнения программы файлы “бэкапов” удаляются.
 */

public class Main {
    static String dirPath = "src/L30_Threads_Files/Task01";
    static String filePath = dirPath + "/result";
    public static void main(String[] args) throws InterruptedException {
        ArrayList list = readFromFile(filePath);

        CommonResources commonResources = new CommonResources(list);
        commonResources.print();

        ThreadSaverV2 saverV2 = new ThreadSaverV2(commonResources, "src/L30_Threads_Files/Task02");

        ThreadChanger changer1 = new ThreadChanger(commonResources);
        ThreadChanger changer2 = new ThreadChanger(commonResources);
        ThreadChanger changer3 = new ThreadChanger(commonResources);

        changer1.start();
        changer2.start();
        changer3.start();
        saverV2.start();

        saverV2.join();
        saverV2.deleteAllBackups();
        commonResources.print();
    }

    private static ArrayList readFromFile(String path) {
        try(FileInputStream reader = new FileInputStream(path)) {
            byte [] datas = null;
            if (reader.available()> 0) {
                datas = new byte[reader.available()];
                reader.read(datas);
            }
            String allData = "";
            for (byte data : datas) {
                allData += (char)data;
            }
            allData = allData.replaceAll(" - ", " ");
            allData = allData.replaceAll("\n", " ");
            ArrayList list = new ArrayList<>(Arrays.asList(allData.split(" ")));
            ArrayList result = new ArrayList<>(list.size() / 2);
            for (int i = 0; i < list.size(); i++) {
                if (i % 2 == 0) continue;
                result.add(list.get(i));
            }
            return result;
        }
        catch (IOException ignored) {}
        return null;
    }
}