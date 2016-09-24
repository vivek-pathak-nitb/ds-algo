package tree;

/**
 * Created by vivek.pathak on 11/03/16.
 */
public class LargestBST {

    private int max = Integer.MIN_VALUE;

    private class Node {
        int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
        }
    }

    private class Wrapper {
        // value to check while comparing root.data
        int valueToCheck;
        int count = 0;
        boolean isBST = false;

        public Wrapper() {
        }
    }

    /**
     * This is the main function which gets executed following bottom up approach.
     *
     * @param root Root node which is to be processed for largest bst.
     * @return number of nodes of the tree which is largest bst
     */
    public int largestBST(final Node root) {
        if (root == null) {
            max = 0;
            return max;
        }

        final Wrapper rootLeftChildWrapper = new Wrapper();
        final Wrapper rootRightChildWrapper = new Wrapper();

        largestBSTUtil(root.left, rootLeftChildWrapper, true, false);
        largestBSTUtil(root.right, rootLeftChildWrapper, false, true);

        // Check for bst by comparing left and right value
        if (isValidBSTNode(rootRightChildWrapper.isBST, rootLeftChildWrapper.isBST, root.data, rootLeftChildWrapper.valueToCheck, rootRightChildWrapper.valueToCheck)) {
            // Calculate the max obtained so far
            max = Math.max(max, rootLeftChildWrapper.count + rootRightChildWrapper.count + 1);
        }

        return max;
    }

    /**
     * @param root    Root of the tree
     * @param wrapper wrapper which contains data corresponding to root.
     * @param isLeft  is left child of its parent
     * @param isRight is right child of its parent.
     */
    public void largestBSTUtil(final Node root, final Wrapper wrapper, final boolean isLeft, final boolean isRight) {
        // If root is null and it is the left child set valueToCheck min value;
        if (root == null && isLeft) {
            wrapper.valueToCheck = Integer.MIN_VALUE;
            wrapper.isBST = true;
            return;
        }

        // If root is null and it is right child set valueToCheck max value;
        if (root == null && isRight) {
            wrapper.valueToCheck = Integer.MAX_VALUE;
            wrapper.isBST = true;
            return;
        }

        // For leaf node.
        if (root.left == null && root.right == null) {
            wrapper.valueToCheck = root.data;
            wrapper.count = 1;
            wrapper.isBST = true;
            return;
        }

        // Tracks count and value to check in the left subtree
        final Wrapper rootLeftChildWrapper = new Wrapper();

        // Tracks count and value to check in the right subtree
        final Wrapper rootRightChildWrapper = new Wrapper();

        largestBSTUtil(root.left, rootLeftChildWrapper, true, false);
        largestBSTUtil(root.right, rootLeftChildWrapper, false, true);

        // Check for bst by comparing left and right value and check left and right subtree are also bst.
        if (isValidBSTNode(rootRightChildWrapper.isBST, rootLeftChildWrapper.isBST, root.data, rootLeftChildWrapper.valueToCheck, rootRightChildWrapper.valueToCheck)) {
            // Calculate the max obtained so far
            max = Math.max(max, rootLeftChildWrapper.count + rootRightChildWrapper.count + 1);
            wrapper.count = rootLeftChildWrapper.count + rootRightChildWrapper.count + 1;
            wrapper.isBST = true;
        } else {
            wrapper.count = 1;
            wrapper.isBST = false;
        }

        wrapper.valueToCheck = root.data;
    }


    private boolean isValidBSTNode(final boolean isRightBST,
                                   final boolean isLeftBST,
                                   final int rootData,
                                   final int leftValueToCheck,
                                   final int rightValueToCheck) {
        return isLeftBST && isRightBST && rootData > leftValueToCheck && rootData < rightValueToCheck;
    }

}
