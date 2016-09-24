package multithreading;

/**
 * Created by vivek.pathak on 28/02/16.
 */
public class OddNumberPrinter implements Runnable {

    private Lock lock;

    public OddNumberPrinter(Lock lock) {
        this.lock = lock;
    }

    @Override
    synchronized public void run() {
        for (int i = 1; i < 20; i += 2) {
            while (lock.isEven) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(i);
            lock.isEven = true;
            notify();
        }
    }
}
