package L30_Threads_Files.Simple;

/**
 * Класс поток для расчётов
 */
public class ThreadForCalculate implements Runnable {
    private CommonResource commonResource;

    /**
     * Коснтруктор с парметром общедоступный ресурс для взаимодействия потоков друг с другом типа commonResource
     * @param commonResource общедоступный ресурс для всех потоков
     */
    ThreadForCalculate(CommonResource commonResource) {
        this.commonResource = commonResource;
    }

    /**
     * Функция реализации логики потока. Поток полчает ячейку данных, печатает её на экран,
     * увеличивает её значение на еденицу и сообщает в общедоступный ресурс, что сделал работу
     * тем самыс увеличивая счётчик "работ"
     */
    @Override
    public void run() {
        while ( commonResource.canDo() ) { //поток будет работать до тех пор, пока ресурс сообщает, что работа возможна
            if ( commonResource.canDo() ) { //дополнительная проверка, чтобы не выйти за границы массива
                System.out.println(Thread.currentThread().getName() + " - " + ++commonResource.getValue().data);
                commonResource.jobDone();
            }
            try { Thread.sleep( (long) (Math.random() * 500) ); }
            catch (InterruptedException e) { e.printStackTrace(); }

        }
        System.out.println(Thread.currentThread().getName() + " was end");
    }
}