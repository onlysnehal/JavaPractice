package datastructure.bst;

public class BinarySearchTreeTest {

    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(6);
        bst.insert(3);
        bst.insert(1);
        bst.insert(8);
        bst.insert(4);
        bst.insert(9);

        System.out.println("---- Pre-Order Traversal ----");
        bst.preOrder();

        System.out.println("---- In-Order Traversal ----");
        bst.inOrder();

        System.out.println("---- Post-Order Traversal ----");
        bst.postOrder();
    }
}
