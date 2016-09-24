package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by vivek.pathak on 28/02/16.
 */
public class ThreadRunner {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> integers = new ArrayBlockingQueue<Integer>(10);
        new Thread(new Producer(integers)).start();
        new Thread(new Consumer(integers)).start();
    }
}
