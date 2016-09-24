package linkedlist;

/**
 * Created by vivek.pathak on 18/05/16.
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {

    }


    public ListNode merge(final ListNode node1, final ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }

        if (node1 == null) {
            return node2;
        }

        if (node2 == null) {
            return node1;
        }

        if (node1.val <= node2.val) {
            final ListNode node1Next = node1.next;
            node1.next = merge(node1.next, node2);
            return node1;
        } else {
            final ListNode node2Next = node2.next;
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode listNode2 = new ListNode(4, new ListNode(5, new ListNode(6, null)));
        ListNode res = new ListNode().merge(listNode1, listNode2);
        System.out.println("DOne merging");
    }
}
