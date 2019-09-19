package L27_Serialization_Files.Task03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;

public class FileUtils {
    private File file;

    FileUtils() {
        file = new File(System.getProperty("user.dir"));
    }

    FileUtils(String path) throws FileNotFoundException {
        file = new File(path);
        if (!file.exists()) throw new FileNotFoundException("");
    }

    public void pwd() {
        System.out.println(file.getAbsolutePath());
    }

    public void ls() {
        for (File file : file.listFiles()) {
            String hint = file.isDirectory() ? "Directory" : "File";
            System.out.println(hint + ": " + file.getName());
        }
    }

    public void ls(String fileType) {
        for (File file : file.listFiles()) {
            if ( matcher(fileType, file.getName()) ) {
                String hint = file.isDirectory() ? "Directory" : "File";
                System.out.println(hint + ": " + file.getName());
            }
        }
    }

    private boolean matcher(String fileType, String subject) {
        Pattern p = Pattern.compile(".+\\." + fileType);
        return p.matcher(subject).matches();
    }

    public boolean mkdir(String name) {
        File newDir = new File(file.getAbsolutePath() + File.separator + name);
        return newDir.mkdir();
    }

    public boolean rm(String path) {
        File rm = new File(file.getAbsolutePath() + File.separator + path);
        return rm.delete();
    }
}