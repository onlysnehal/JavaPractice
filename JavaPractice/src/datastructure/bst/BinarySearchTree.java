package datastructure.bst;

public class BinarySearchTree {

    private TreeNode root;

    public void insert(int data) {
        if (root == null) {
            this.root = new TreeNode(data);
        } else {
            root.insert(data);
        }
    }

    public TreeNode find(int data) {
        if (root != null) {
            return root.find(data);
        }
        return null;
    }


    //Tree traversal by in-order
    public void inOrder() {
        inOrderRec(root);
    }

    public void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.getLeftChild());
            System.out.println(root.getData());
            inOrderRec(root.getRightChild());
        }
    }

    //Tree traversal by pre-order
    public void preOrder() {
        preOrderRec(root);
    }

    public void preOrderRec(TreeNode root) {
        if (root != null) {
            System.out.println(root.getData());
            preOrderRec(root.getLeftChild());
            preOrderRec(root.getRightChild());
        }
    }

    //Tree traversal by post-order
    public void postOrder() {
        postOrderRec(root);
    }

    public void postOrderRec(TreeNode root) {
        if (root != null) {
            postOrderRec(root.getLeftChild());
            postOrderRec(root.getRightChild());
            System.out.println(root.getData());
        }
    }
}
