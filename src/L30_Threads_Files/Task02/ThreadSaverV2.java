package L30_Threads_Files.Task02;

import L30_Threads_Files.Task01.CommonResources;
import L30_Threads_Files.Task01.ThreadSaver;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreadSaverV2 extends ThreadSaver {
    private int backup;
    {
        backup = 0;
    }
    public ThreadSaverV2(CommonResources commonResources, String path) {
        super(commonResources, path);
    }

    @Override
    protected void writeToFile(String doNotUsed) {
        String filePath = path + "/.backup_" + backup++;
        File file = new File( filePath );
        file.mkdir();
        super.writeToFile(file.getPath());
    }

    public void deleteAllBackups() {
        ArrayList<File> files = null;
        {
            File file = new File(path);
            if ( file.isDirectory() ) {
                files = new ArrayList<>(Arrays.asList(file.listFiles()));
            }
        }

        files.forEach(file -> {
            if (file.getName().contains("backup"))
                file.delete();
        });
    }
}