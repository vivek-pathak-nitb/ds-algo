package oracle.test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;


public class IteratorFlattenerNew<E> implements Iterator<E> {
    Iterator<Iterator<E>> rootcopy = null;
    private final Stack<Iterator<E>> iterators = new Stack<Iterator<E>>();

    public IteratorFlattenerNew(Iterator<Iterator<E>> arr3) {
        rootcopy = arr3;
        if (arr3 == null) {
            throw new RuntimeException("Iterator cannot be null.");
        }
        iterators.push(arr3.next());
    }


    public boolean hasNext() {
        // TODO Auto-generated method stub
        Iterator<E> temp = iterators.peek();
        if (temp.hasNext())
            return true;
        else {
            while (rootcopy.hasNext()) {
                iterators.push(rootcopy.next());
                if (iterators.peek().hasNext())
                    return true;

            }
            return false;
        }
    }

    public E next() {
        if (hasNext()) {
            return iterators.peek().next();
        } else
            throw new NoSuchElementException();
        // TODO Auto-generated method stub
    }

    public void remove() {
        iterators.peek().remove();
    }

    public static void main(String args[]) {
        List<Integer> arr1 = new ArrayList<Integer>();
        List<Integer> arr2 = new ArrayList<Integer>();
        List<Integer> arr3 = new ArrayList<Integer>();
        arr1.add(1);
        arr2.add(2);
        arr3.add(3);

        List<Iterator<Integer>> arr4 = new ArrayList<Iterator<Integer>>();
        arr4.add(arr1.iterator());
        arr4.add(arr2.iterator());
        arr4.add(arr3.iterator());

        IteratorFlattenerNew ifn = new IteratorFlattenerNew(arr4.iterator());
        while (ifn.hasNext()) {
            System.out.println(ifn.next());
        }
    }

}

