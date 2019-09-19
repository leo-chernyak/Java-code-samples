package L30_Threads_Files.Task01;

import java.util.Random;

public class ThreadChanger extends Thread {
    CommonResources commonResources;
    public ThreadChanger(CommonResources commonResources) {
        this.commonResources = commonResources;
    }
    @Override
    public void run() {
        while ( commonResources.isCan() ) {
            DataCell data = commonResources.getDataCell();
            if (data == null) break;
            data.str = changeStr( data.str );
            System.out.println( Thread.currentThread().getName() + " change pos: " + data.pos + " value: " + data.str  );
            commonResources.jobDone();
            try {
                Thread.sleep(new Random().nextInt(200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String changeStr( String str ) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < str.length() / 2; i++) {
            sb.setCharAt(i, str.charAt(str.length() - 1 - i));
            sb.setCharAt(str.length() - 1 - i, str.charAt(i));
        }
        return sb.toString();
    }
}