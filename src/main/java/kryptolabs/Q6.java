package kryptolabs;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Q6 {

    private class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;

        public TreeNode(final String val,
                        final TreeNode left,
                        final TreeNode right) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    private static final List<TreeNode> LIST_OF_NODES = new ArrayList<>();

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            return;
        }

        final Q6 q6 = new Q6();

        final TreeNode root = q6.createBalancedBinaryTree(args, 0, args.length - 1);
        final Random random = new Random();

        System.out.println(q6.getMinDistance(root,
                LIST_OF_NODES.get(random.nextInt(LIST_OF_NODES.size())),
                LIST_OF_NODES.get(random.nextInt(LIST_OF_NODES.size()))));
    }

    private TreeNode createBalancedBinaryTree(final String[] arr,
                                              final int low,
                                              final int high) {
        if (low > high) {
            return null;
        }

        if (low == high) {
            return new TreeNode(arr[low], null, null);
        }

        final int mid = low + (high - low) / 2;

        final TreeNode root = new TreeNode(arr[mid], null, null);
        LIST_OF_NODES.add(root);

        root.left = createBalancedBinaryTree(arr, low, mid - 1);
        root.right = createBalancedBinaryTree(arr, mid + 1, high);

        return root;
    }

    private int getMinDistance(final TreeNode root,
                               final TreeNode node1,
                               final TreeNode node2) {
        final TreeNode lca = getLCA(root, node1, node2);
        final int node1Distance = getDistanceFromLCA(lca, node1, 0);
        final int node2Distance = getDistanceFromLCA(lca, node2, 0);
        return node1Distance + node2Distance + 1;
    }

    private TreeNode getLCA(final TreeNode root, final TreeNode node1, final TreeNode node2) {
        if (root == null) {
            return null;
        }

        if (root.left == node1 || root.left == node2 || root.right == node1 || root.right == node2) {
            return root;
        }

        final TreeNode left = getLCA(root.left, node1, node2);
        final TreeNode right = getLCA(root.right, node1, node2);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        return right;
    }

    private int getDistanceFromLCA(final TreeNode root, final TreeNode node, final int distance) {
        if (root == null) {
            return -1;
        }

        if (node == null) {
            return -1;
        }

        if (root.left == node || root.right == node) {
            return distance + 1;
        }

        final int left = getDistanceFromLCA(root.left, node, distance + 1);
        final int right = getDistanceFromLCA(root.right, node, distance + 1);

        if (left != -1) {
            return left;
        }

        return right;
    }

}
