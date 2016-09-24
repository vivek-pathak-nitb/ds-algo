package kryptolabs;

public class Q2 {

    private class Node {
        String value;
        Node next;

        public Node(final Node next, final String value) {
            this.next = next;
            this.value = value;
        }
    }

    public static void main(final String[] args) {
        final Q2 q2 = new Q2();

        // Creating list.
        final Node currHead = q2.createLinkList(args);

        // Printing reversed list.
        Node curr = q2.reversedList(currHead);
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
    }

    private Node createLinkList(final String[] values) {
        Node head = null;
        Node prev = null;
        for (final String value : values) {
            final Node curr = new Node(null, value);
            if (prev != null) {
                prev.next = curr;
            }

            if (head == null) {
                head = curr;
            }
            prev = curr;
        }

        return head;
    }

    private Node reversedList(final Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
