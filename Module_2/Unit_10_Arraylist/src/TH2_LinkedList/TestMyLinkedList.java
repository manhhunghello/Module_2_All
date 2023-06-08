package TH2_LinkedList;

public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList(null);
//       ll.addFirst(11);
//        ll.addFirst(12);
//        ll.addFirst(13);
        ll.add(4,9);
        ll.add(4,9);
        ll.add(2,3);
        ll.add(1,4);
        ll.add(2,5);
        ll.addLast(13);
//        ll.addFirst(56);

        ll.printList();
    }
}