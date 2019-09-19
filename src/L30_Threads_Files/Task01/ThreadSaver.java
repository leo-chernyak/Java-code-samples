package L30_Threads_Files.Task01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class ThreadSaver extends Thread {
    private CommonResources commonResources;
    private int saved;
    private int size;
    public final String path;
    public ThreadSaver(CommonResources commonResources, String path) {
        this.commonResources = commonResources;
        this.path = path;
        this.saved = 0;
        this.size = commonResources.getDatas().size();
    }
    @Override
    public void run() {
        while ( saved < size ) {
            if (commonResources.jobs >= 10) {
                commonResources.jobs -= 10;
                saved += 10;
                writeToFile(path);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void writeToFile(String path){
        System.out.println("Start write to file " + path);
        try (FileWriter writer = new FileWriter(path, false)) {
            ArrayList<DataCell> datas = commonResources.getDatas(); //получаем копи. данных для записи в файл
            AtomicReference<String> res = new AtomicReference<>("");
            datas.forEach(dataCell -> res.updateAndGet(v -> v + dataCell.getDescryption() + (dataCell.pos % 10 == 9 ? "\n" : " ")));
            System.out.println(res);
            writer.write(res.toString());
        }
        catch (IOException ignored) { }
        System.out.println("End write to file " + path);
    }
}