package datastructure.linkedlist;

public class Node {
    private Node nextNode;
    private int data;

    public Node(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return data + " -> ";
    }
}
