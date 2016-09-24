package linkedlist;

import com.google.common.collect.Lists;

import java.util.List;

public class LinkedList<T> {

    private Node<T> head;

    public LinkedList() {

    }

    public LinkedList(final T data) {
        head = new Node<T>(data);
    }

    public void insert(final T data) {
        if (head == null) {
            head = new Node<T>(data);
            return;
        }

        Node<T> itr = head;
        while (itr.getNext() != null) {
            itr = itr.getNext();
        }

        final Node<T> newNode = new Node<T>(data);
        itr.setNext(newNode);
    }

    public void insertAll(final List<T> data) {
        if (data == null || data.size() == 0) {
            return;
        }

        for (final T toInsert : data) {
            insert(toInsert);
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getMiddle() {
        Node<T> fast = head;
        Node<T> slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }

    public static void main(String[] args) {
        final LinkedList<Integer> integerLinkedList = new LinkedList<Integer>();
        integerLinkedList.insertAll(Lists.newArrayList(1, 2, 3, 4, 5));
        System.out.println(integerLinkedList.getMiddle().getData());
    }

}
