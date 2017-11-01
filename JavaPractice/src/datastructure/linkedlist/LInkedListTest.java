package datastructure.linkedlist;

public class LInkedListTest {
    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.insertAtFirst(1);
        list.insertAtFirst(2);
        list.insertAtFirst(3);
        list.insertAtFirst(4);
        list.insertAtFirst(5);
        list.print();
        System.out.println();
        System.out.println("Total nodes : " + list.getLength());
        list.deleteAtFirst();
        System.out.println("\nAfter deleting first node : ");
        list.print();
        System.out.println();
        System.out.println("Total nodes : " + list.getLength());
    }
}
