package tree;

/**
 * Created by vivek.pathak on 10/09/16.
 */
public class BalancedBinaryTree {

    public boolean isBalancedTree(final TreeNode<Integer> root) {
        return root == null || isBalancedUtil(root) > -1;
    }


    private int isBalancedUtil(final TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        if (root.getLeftChild() == null && root.getRightChild() == null) {
            return 1;
        }

        int left = isBalancedUtil(root.getLeftChild());
        int right = isBalancedUtil(root.getRightChild());

        if (left == -1 || right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
