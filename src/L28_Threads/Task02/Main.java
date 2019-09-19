package L28_Threads.Task02;

public class Main {
    static int [] array;
    static { array = new int[50]; }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1_000; i++) {
            Image image = new Image();
            Thread thread1 = new Thread(new Fill(image));
            Thread thread2 = new Thread(new Fill(image));
            Thread thread3 = new Thread(new Fill(image));

            thread1.start();
            thread2.start();
            thread3.start();

            thread1.join();
            thread2.join();
            thread3.join();

            for (int j = 0; j < image.pixels.length; j++) {
                if ( image.pixels[j].value == 0 ) System.out.println("заполнено не все: " + image.pixels[j]);
            }
            for (int j = 0; j < image.pixels.length; j++) {
                if ( image.pixels[j].value > 1 ) System.out.println("заполнено " + image.pixels[j].value + " раз");
            }
        }
    }
}