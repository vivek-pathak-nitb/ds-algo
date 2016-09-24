
public class LinkedList {

    public Node head;

    private class Node {

        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node insert(int value) {
        if (head == null) {
            head = new Node(value);
            return head;
        }

        Node curr = head;
        Node prev = null;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = new Node(value);
        return prev.next;
    }

    private void insertCycle(Node startNode, Node lastNode) {
        lastNode.next = startNode;
    }

    private void correctLoop(Node head) {
        if (head == null) {
            return;
        }

        Node fast = head;
        Node slow = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (slow == fast && slow != head) {
            correctLoopUtil(slow, fast);
        }
    }

    private void correctLoopUtil(Node slow, Node fast) {
        Node temp1 = slow;
        Node temp2 = fast.next;
        int length = 1;

        // Calculate the length
        while (temp1 != temp2) {
            temp2 = temp2.next;
            length++;
        }

        temp1 = head;
        temp2 = head;

        // Move node K distance ahead.
        for (int i = 0; i < length; i++) {
            temp2 = temp2.next;
        }

        // find head of list
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        // find last node;
        while (temp2.next != temp1) {
            temp2 = temp2.next;
        }

        // fixing
        temp2.next = null;
    }

    public static void main(String[] args) {
        final LinkedList linkedList = new LinkedList();

        linkedList.insert(1);
        linkedList.insert(2);
        final Node startCycleNode = linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.insert(6);
        final Node endCycleNode = linkedList.insert(7);

        linkedList.insertCycle(startCycleNode, endCycleNode);

        linkedList.correctLoop(linkedList.head);

        Node curr = linkedList.head;
        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }


}
