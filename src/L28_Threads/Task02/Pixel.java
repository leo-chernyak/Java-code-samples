package L28_Threads.Task02;

public class Pixel {
    int position;
    int value;
    public Pixel(int position) {
        this.position = position;
    }
    @Override
    public String toString() {
        return "value: " + value + ", position: " + position;
    }
}
