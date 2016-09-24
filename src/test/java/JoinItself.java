/**
 * Created by vivek.pathak on 04/02/16.
 */
public class JoinItself extends Thread {

    public void run() {
        System.out.println("Inside the run method ");
        System.out.println(Thread.currentThread().isAlive());
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("Joining itself ...");
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        JoinItself j = new JoinItself();

        System.out.println(j.isAlive());
        j.start();
        System.out.println(j.isAlive());
        System.out.println("Thread started ...");

    }

}