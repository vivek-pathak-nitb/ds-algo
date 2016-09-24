package tree;

import java.util.Comparator;

/**
 * Created by vivek.pathak on 26/08/15.
 */
public class TreeNode<T extends Comparable<T>> {

    private T data;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    public TreeNode(final T data,
                    final TreeNode<T> leftChild,
                    final TreeNode<T> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(final TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(final TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}
