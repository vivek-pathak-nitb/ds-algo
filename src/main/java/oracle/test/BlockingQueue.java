package oracle.test;

import java.util.Queue;

/**
 * Provides waiting thread-safe access to a java.util.Queue.
 */
public class BlockingQueue<E> {

    private final Queue<E> queue;
    private volatile boolean isFree = true;

    /**
     * @param queue Warning: queue may or may not be empty at the moment of calling this constructor.
     *              Warning: queue may or may not be a thread-safe implementation.
     *              Assumption: after been passed into this constructor, queue object is not used by any code outside this class.
     */
    public BlockingQueue(Queue<E> queue) {
        this.queue = queue;
    }

    /**
     * Inserts the specified element into the underlying queue, waiting if necessary for the underlying queue to be ready
     * to accept new elements.
     */
    public void push(E e) throws InterruptedException {
        while (!isFree) {
            synchronized (this) {
                wait();
            }
        }

        synchronized (this) {
            if (queue != null) {
                queue.add(e);
            }
            isFree = true;
            notifyAll();
        }
    }

    /**
     * Retrieves and removes the head of the underlying queue, waiting if necessary until it is capable of providing an element.
     */
    public E pull() throws InterruptedException {
        while (!isFree) {
            synchronized (this) {
                wait();
            }
        }

        synchronized (this) {
            if (queue != null && !queue.isEmpty()) {
                E element = queue.poll();
                isFree = true;
                notifyAll();
                return element;
            }
        }

        return null;
    }
}
