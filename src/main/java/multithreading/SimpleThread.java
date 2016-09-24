package multithreading;

/**
 * Created by vivek.pathak on 28/02/16.
 */
public class SimpleThread implements Runnable {

    private final String var;

    public SimpleThread(String var) {
        this.var = var;
    }

    @Override
    public void run() {
        System.out.println(" Hello world " + var);
    }
}
