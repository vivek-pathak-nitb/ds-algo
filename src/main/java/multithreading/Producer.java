package multithreading;

import java.util.concurrent.BlockingQueue;

/**
 * Created by vivek.pathak on 13/05/16.
 */
public class Producer implements Runnable {

    private final BlockingQueue<Integer> blockingQueue;

    public Producer(final BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                blockingQueue.put(i);
                System.out.println("Producing " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}
