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

    public void insertAtLast(int data) {
        // Create a new node to insert at first
        Node newNode = new Node(data);

        Node currentNode = this.head;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(newNode);
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

    public void reverseList() {
        Node currentNode = this.head;
        Node nextNode;
        Node previousNode = null;

        while (currentNode != null) {
            nextNode = currentNode.getNextNode();
            currentNode.setNextNode(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;

        }
        this.head = previousNode;
    }

    public boolean checkForCycle() {
        if (this.head == null) {
            return false;
        } else {
            //Using two pointers
            Node slowNode = this.head;
            Node fastNode = this.head.getNextNode();

            while (fastNode != null && fastNode.getNextNode() != null && slowNode != fastNode) {
                slowNode = slowNode.getNextNode();
                fastNode = fastNode.getNextNode().getNextNode();

            }
            return slowNode == fastNode;
        }
    }
}
