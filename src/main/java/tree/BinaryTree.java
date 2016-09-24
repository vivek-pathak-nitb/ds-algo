package tree;

/**
 * Created by vivek.pathak on 26/08/15.
 */
public class BinaryTree<T extends Comparable<T>> {

    protected TreeNode<T> root;

    public BinaryTree(final TreeNode<T> root) {
        this.root = root;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(final TreeNode<T> root) {
        this.root = root;
    }

    public boolean addLeftChild(final TreeNode<T> parentNode, final TreeNode<T> leftChild) {
        if (parentNode == null) {
            return false;
        }
        parentNode.setLeftChild(leftChild);
        return true;
    }

    public boolean addRightChild(final TreeNode<T> parentNode, final TreeNode<T> rightChild) {
        if (parentNode == null) {
            return false;
        }
        parentNode.setRightChild(rightChild);
        return true;
    }

    public void preOrderTraversal(final TreeNode<T> root) {
        if (root == null) {
            return;
        }

        System.out.println(root.getData());
        preOrderTraversal(root.getLeftChild());
        preOrderTraversal(root.getRightChild());
    }

    public void inOrderTraversal(final TreeNode<T> root) {
        if (root == null) {
            return;
        }

        preOrderTraversal(root.getLeftChild());
        System.out.println(root.getData());
        preOrderTraversal(root.getRightChild());
    }

    public void postOrderTraversal() {
        if (root == null) {
            return;
        }

        preOrderTraversal(root.getLeftChild());
        preOrderTraversal(root.getRightChild());
        System.out.println(root.getData());
    }
}
