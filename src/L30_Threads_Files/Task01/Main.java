package L30_Threads_Files.Task01;

/**
 * Создать класс общеступный ресурс, который будет содержать в себе массив с
 * данными содержащий в себе строку и уникальную позицию. Строка генерируется и состоит из
 * случайных символов. Создать два класса для работы с потоками. Один из них записывает
 * данные в файл каждые 10 изменений данных в общем массиве и работает бесконечно. Второй
 * берет одну строку из массива и меняет все буквы в строке следующим образом. Например
 * строка ABBCCA, генерируется случайное число(например два) и каждый символ в строке
 * меняется на следующий с учётом сдвига в алфавите. Получаем строку BDDEEB.
 */

public class Main {
    public static void main(String[] args) {
        CommonResources commonResources = new CommonResources();
        commonResources.print();

        ThreadSaver saver = new ThreadSaver(commonResources, "src/L30_Threads_Files/Task01/result");
        ThreadChanger changer1 = new ThreadChanger(commonResources);
        ThreadChanger changer2 = new ThreadChanger(commonResources);
        ThreadChanger changer3 = new ThreadChanger(commonResources);

        changer1.start();
        changer2.start();
        changer3.start();
        saver.start();
    }
}