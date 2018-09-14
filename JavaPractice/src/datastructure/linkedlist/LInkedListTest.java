package datastructure.linkedlist;

public class LInkedListTest {
    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.insertAtFirst(1);
        list.insertAtFirst(2);
        list.insertAtFirst(3);
        list.insertAtFirst(4);
        list.insertAtFirst(5);
        list.insertAtLast(12);
        list.print();
        System.out.println("\n Total nodes : " + list.getLength());
        list.deleteAtFirst();
        System.out.println("\n After deleting first node : ");
        list.print();
        System.out.println("\n Total nodes : " + list.getLength());
        System.out.println("\n Reverse linked list :");
        list.reverseList();
        list.print();
        System.out.println("\n Linked list has cycle : " + list.checkForCycle());

    }
}
