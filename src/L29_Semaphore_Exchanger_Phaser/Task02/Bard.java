package L29_Semaphore_Exchanger_Phaser.Task02;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;

public class Bard extends Thread {
    private static volatile boolean canSend;
    private static volatile int registered;
    private static ArrayList<Long> lisID;
    private boolean isGot;
    private Phaser phaser;
    private Exchanger<String> exchanger;
    private ArrayList<String> song;
    public ArrayList<String> newSong;
    static {
        lisID = new ArrayList<>();
        canSend = true;
    }
    public Bard(Phaser phaser, Exchanger<String> exchanger, ArrayList<String> song) {
        this.phaser = phaser;
        this.exchanger = exchanger;
        this.song = song;
        this.newSong = new ArrayList<>();
        isGot = false;
        phaser.register();
    }
    @Override
    public void run() {
        registered = phaser.getRegisteredParties();
        try {
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < 4; i++) {
                    if ( isSend() ) {
                        System.out.println(j  + " " + i + " " + getId());
                        sendWord();
                        System.out.println(getId() + " sending stop. " + phaser.getUnarrivedParties());
                    }
                    else {
                        getWord();
                        System.out.println(getId() + " getting stop. " + phaser.getUnarrivedParties());
                    }
                    upDate();
                }
                lisID.clear();
                phaser.arriveAndAwaitAdvance();
            }
            phaser.arriveAndDeregister();
        }
        catch (InterruptedException ignored) {}
    }
    private void upDate() {
        phaser.arriveAndAwaitAdvance();
        System.out.println("done");
        isGot = false;
        registered = phaser.getRegisteredParties();
        canSend = true;
        phaser.arriveAndAwaitAdvance();
    }
    private void getWord() throws InterruptedException {
        while ( !isGot ) {
            String word = null;
            word = exchanger.exchange(null);
            if ( word == null || isGot ) { continue; }
            synchronized (Bard.class) {
                System.out.println(getId() + " got " + registered);
                deregister();
                isGot = true;
            }
            newSong.add(word);
          Thread.sleep(100);
        }
    }
    private void sendWord() throws InterruptedException {
        String word = song.get(new Random().nextInt(song.size() -1 ));
        newSong.add(word);
        while ( getRegistered() > 1 ) {
            System.out.println(getId() + " send " + word);
            exchanger.exchange(word);
          Thread.sleep(100);
        }
        deregister();
    }
    private int getRegistered() {
        synchronized (Bard.class) {
            return registered;
        }
    }
    private void deregister(){
        synchronized (Bard.class) {
            registered--;
        }
    }
    private boolean isSend() throws InterruptedException {
        synchronized (Bard.class) {
            long threadID = Thread.currentThread().getId();
            boolean contains = lisID.contains(threadID);
            if ( canSend && !contains ) {
                lisID.add(threadID);
                canSend = false;
                return true;
            }
            return false;
        }
    }
}