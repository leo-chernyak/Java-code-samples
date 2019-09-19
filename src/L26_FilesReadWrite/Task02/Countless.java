package L26_FilesReadWrite.Task02;

public class Countless extends Human {
    public Countless(String name, int x, int y) {
        super(name, "female", x, y);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + "\t" + super.toString();
    }

}