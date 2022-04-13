package _10_List.exercise.LinkedList;

public class TestLinkedList {
    public static void main (String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList(0);
        for (int i = 1 ; i < 10 ; i++)
            ll.addLast(i);
        ll.delHead();
        ll.addLast(10);
        ll.addFirst(0);

//        System.out.println("Vi tri " + 5 + ": " + ll.get(5));
//        System.out.println("Gia tri 4 tai vi tri: " + ll.search(4));
//        ll.addAt(33, 5);
//        ll.delAt(4);
//        System.out.println(ll.search(3));
//        ll.removeObj(10);

        MyLinkedList ll2;
        ll2 = ll.clone();
        ll2.printList();
    }
}
