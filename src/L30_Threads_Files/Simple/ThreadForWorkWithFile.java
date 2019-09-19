package L30_Threads_Files.Simple;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс потока для работы с записью в файл
 */
public class ThreadForWorkWithFile implements Runnable {

    private final String wayToFile = "src/L30_Threads_Files/Simple/tmp/file";//переменная хранящая шаблон пути файла
    private CommonResource commonResource;
    private int countOfBackup;//счётчик номера файла

    /**
     * Коснтруктор с парметром общедоступный ресурс для взаимодействия потоков друг с другом типа commonResource
     * @param commonResource общедоступный ресурс для всех потоков
     */
    public ThreadForWorkWithFile(CommonResource commonResource) {
        this.commonResource = commonResource;
        countOfBackup = 0;
    }


    /**
     * Функция реализации логики потока
     */
    @Override
    public void run() {
        while ( true ) {
            System.out.println(commonResource.jobs);
            if (commonResource.jobs >= 5) {//если было произведено 5 "работ" с данными то делаем бэкап
                writeToFile(wayToFile + (countOfBackup++)); //пишем файл c с новым путем
                commonResource.jobs -= 5;//и уменьшаем счетчик работ на 5 тем самым показывая, что 5 изменений мы записали
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Функция записи в файл по заданному пути
     * @param fileName путь к файлу вместе с его названием
     */
    private void writeToFile(String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName, false)) {
            System.out.println("Start write to file " + fileName);
            String res = ""; //строка которая будет записана в файл. Далее её формируем
            DataCell[] data = commonResource.getAllData();//получаем копи. данных для записи в файл
            for (int i = 0; i < data.length; i++) { //формируем строку для записи
                res += data[i].data;
                res += "_";
                if (i % 10 == 0 && i != 0) {
                    res += "\r";
                }
            }
            fileWriter.write(res);//пишем в файл
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("End write to file " + fileName);
    }
}
