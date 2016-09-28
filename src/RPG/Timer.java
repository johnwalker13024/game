package RPG;

import javax.swing.*;
import java.util.concurrent.CompletableFuture;

/**
 * Runs a timer and notifies the listener when finished
 * Created by johnathon on 9/27/2016.
 */
public class Timer extends SwingWorker<Void, Integer> {

    private long time;
    private TimerListener listener;

    /**
     * constructor: requires the time in milliseconds as well as a listener that will be notified upon completion
     * @param time milliseconds
     * @param listener will be notified upon completion
     */
    public Timer(long time, TimerListener listener) {
        if (time == 0 || listener == null) {
            return; //todo: change to throw an exception
        }
        this.time = time;
        this.listener = listener;
    }

    @Override
    protected Void doInBackground() throws Exception {
        long startTime = System.nanoTime() / 1000000; // converting from nano to milli

        while ((System.nanoTime() / 1000000) < startTime + time) {
            //System.out.println("current time" + System.nanoTime() * 1000000);
            // do nothing... we are waiting
        }

        return null;
    }

    @Override
    protected void done() {
        listener.update();
    }
}
