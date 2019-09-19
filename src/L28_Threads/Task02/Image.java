package L28_Threads.Task02;

public class Image {
    public Pixel [] pixels;
    int position;
    public Image() {
        pixels = new Pixel[50];
        for (int i = 0; i < 50; i++) {
            pixels[i] = new Pixel(i);
        }
    }
    public boolean hasNext() {
        return position < pixels.length;
    }
    public synchronized Pixel getPixel() {
        if (hasNext())
            return pixels[position++];
        return null;
    }
}
