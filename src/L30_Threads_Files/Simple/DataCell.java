package L30_Threads_Files.Simple;

class DataCell {
    int pos;
    int data;
    int countOfChanging;

    /**
     * Конструктор с парметрами
     * @param pos позиция элемента в массиве. Все должны быть уникальные
     * @param data значение
     */
    DataCell(int pos, int data) {
        this.pos = pos;
        this.data = data;
    }
}