package L30_Threads_Files.Simple;

/**
 * Класс для синхронизации и общения между потоками
 */
public class CommonResource {
    private DataCell[] data;
    int jobs; //сколько было произведено действий
    private int countOfRead; //счётчик, по которому можно брать данные

    public CommonResource() {
        fillData();
        jobs = 0;
        countOfRead = 0;
    }

    /**
     * Функция заполнения даты
     */
    private void fillData() {
        data = new DataCell[50];
        for (int i = 0; i < data.length; i++) {
            data[i] = new DataCell(i, (int) (Math.random() * 100));
        }
    }

    /**
     * Конструктор, который на вход принимает массив типа DataCell
     * @param data массив с данными типа DataCell
     */
    CommonResource(DataCell[] data) {
        this.data = data;
        jobs = 0;
        countOfRead = 0;
    }

    /**
     * Функция возваращает указатель на одну из ячеек и увеличивает счётчик по которому модно брат на еденицу
     * @return ячейку данных типа DataCell
     */

    synchronized DataCell getValue() {
        return data[countOfRead++];
    }

    /**
     * Функция, которая показывает, что было произведене действие с ячейкой данных
     */
    synchronized void jobDone() {
        jobs++;
    }

    /**
     * Функция, которая возращяет копию данных
     * @return массив типа DataCell с копией данных
     */
    synchronized DataCell[] getAllData() {
        DataCell[] tmpData = new DataCell[data.length];
        for (int i = 0; i < data.length; i++) {
            tmpData[i] = new DataCell(data[i].pos, data[i].data);
        }
        return tmpData;
    }

    /**
     * Функция печати данных на экран
     */
    void printData() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i].data + " ");
            if (i % 10 == 0 && i != 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Функция проверки не достигли ли конца массива
     * @return true если индекс того, какую ячейку брать меньше длины массива, false если больше либо равен
     */
    synchronized boolean canDo() {
        return countOfRead < data.length;
    }
}