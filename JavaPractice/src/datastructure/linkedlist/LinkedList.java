package datastructure.linkedlist;

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insertAtFirst(int data) {
        // Create a new node to insert at first
        Node newNode = new Node(data);
        // attach head to new node
        newNode.setNextNode(this.head);
        // now head becomes new node
        this.head = newNode;
    }

    public void deleteAtFirst() {
        this.head = this.head.getNextNode();
    }

    public void print() {
        // Mark head node as current node
        Node currentNode = this.head;

        // Iterate over the list
        while (currentNode != null) {
            System.out.print(currentNode);
            if (currentNode.getNextNode() == null) {
                System.out.println("null");
            }
            currentNode = currentNode.getNextNode();
        }
    }

    public int getLength() {
        int length = 0;
        Node currentNode = this.head;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNextNode();
        }
        return length;
    }
}
