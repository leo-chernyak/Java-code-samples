package L28_Threads.Task02;

import java.util.Random;

class Fill implements Runnable {
    private Image image;
    public Fill(Image image) {
        this.image = image;
    }

    @Override
    public void run() {
        while ( image.hasNext() ) {
            Pixel pixel = image.getPixel();
            if (pixel != null)
                pixel.value++;
            try { Thread.sleep(new Random().nextInt(1)); }
            catch (InterruptedException ignored) { }
        }
    }
}