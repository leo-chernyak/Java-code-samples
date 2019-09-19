package L30_Threads_Files.Simple;

/**
 * Задача. Создать класс общественный ресурс, где будет массив с даннымы, где одная ячейка это класс содержащий
 * в себе значение и позицию. Создать два класса для работы с потоками. Один тип будет обрабатывать данные,
 * увеличивая значение данных в массиве на еденичку. Второй класс, каждый раз, когда произойдёт увеличение значений
 * в массиве 5 раз, то производит запись всех данных в файл, каждый раз генерируя новый и сохраняя при этом старые.
 */

public class Main {
    public static void main(String[] args) {

        CommonResource commonResource = new CommonResource();

        commonResource.printData();
        Thread first = new Thread(new ThreadForCalculate(commonResource));
        Thread second = new Thread(new ThreadForCalculate(commonResource));
        Thread third = new Thread(new ThreadForCalculate(commonResource));
        Thread four = new Thread(new ThreadForWorkWithFile(commonResource));

        first.start();
        second.start();
        third.start();
        four.start();

        try {
            first.join();
            second.join();
            third.join();
            four.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        commonResource.printData();
    }
}
