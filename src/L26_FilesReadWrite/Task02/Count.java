package L26_FilesReadWrite.Task02;

public class Count extends Human {
    public Count(String name, int x, int y) {
        super(name, "male", x, y);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + "\t" + super.toString();
    }
}
