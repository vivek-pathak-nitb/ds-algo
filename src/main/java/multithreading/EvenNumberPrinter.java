package multithreading;

/**
 * Created by vivek.pathak on 28/02/16.
 */
public class EvenNumberPrinter implements Runnable {

    private Lock lock;

    public EvenNumberPrinter(Lock lock) {
        this.lock = lock;
    }

    @Override
    synchronized public void run() {
        for (int i = 2; i < 20; i += 2) {
            while (!lock.isEven) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(i);
            lock.isEven = false;
            notify();
        }
    }
}
