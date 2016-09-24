package multithreading;

import java.util.concurrent.BlockingQueue;

/**
 * Created by vivek.pathak on 13/05/16.
 */
public class Consumer implements Runnable {
    private final BlockingQueue<Integer> blockingQueue;

    public Consumer(final BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        while (true) {
            try {
                System.out.println("Taking from Queue" + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
