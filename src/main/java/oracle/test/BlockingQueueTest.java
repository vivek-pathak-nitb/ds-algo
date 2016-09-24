package oracle.test;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueueTest {

    public static void main(String[] args) {
        final Queue<Integer> integerQueue = new LinkedList<Integer>();
        final BlockingQueue<Integer> integerBlockingQueue = new BlockingQueue<Integer>(integerQueue);

        // Thread 1
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int idx = 0; idx < 10; idx++) {
                    try {
                        integerBlockingQueue.push(idx);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });

        // Thread 2
        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int idx = 0; idx < 10; idx++) {
                    try {
                        System.out.println(integerBlockingQueue.pull());
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });

        // Thread 3
        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int idx = 0; idx < 10; idx++) {
                    try {
                        integerBlockingQueue.push(idx);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });

        // Thread 4
        final Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int idx = 0; idx < 10; idx++) {
                    try {
                        System.out.println(integerBlockingQueue.pull());
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

}
