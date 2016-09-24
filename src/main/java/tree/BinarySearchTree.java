package tree;

/**
 * Created by vivek.pathak on 26/08/15.
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    public BinarySearchTree(final TreeNode<T> root) {
        super(root);
    }

    public void addNode(final TreeNode<T> root, final T data) {
        if (root == null) {
            return;
        }

        if (root.getData().compareTo(data) > 0) {

            if (root.getLeftChild() == null) {
                root.setLeftChild(new TreeNode<T>(data, null, null));
                return;
            }

            addNode(root.getLeftChild(), data);
        } else if (root.getData().compareTo(data) < 0) {

            if (root.getRightChild() == null) {
                root.setRightChild(new TreeNode<T>(data, null, null));
                return;
            }

            addNode(root.getRightChild(), data);
        }

    }
}
