package chapter2;

import java.util.HashSet;
import java.util.Set;

public class Q1FindDups {
    public static void main(String[] args) {
        Node head = createLinkedList();
        deleteDups(head);
//        deleteDupsNoBuffer(head);
//        myDeleteDups(head);
//        deleteDupsNoBufferMain(head);
        head.print();
    }

    static Node createLinkedList() {
        Node head = new Node(0);
        head.appendToTail(1);
        head.appendToTail(2);
//        head.appendToTail(2);
//        head.appendToTail(2);
//        head.appendToTail(2);
//        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(3);
//        head.appendToTail(3);
//        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(3);
        head.appendToTail(5);
        head.appendToTail(4);
        head.appendToTail(4);
        head.appendToTail(6);
        head.appendToTail(6);

//        head.appendToTail(3);
        return head;
    }

    static void deleteDups(Node head) {
        Set<Integer> values = new HashSet<>();
//        Node head = head;
        Node prev = head;

        while (head != null) {
            if (values.contains(head.data)) {
                prev.next = head.next;
            } else {
                values.add(head.data);
                prev = head;
            }
            head = head.next;
        }
    }

    /**
     * Nice one (with no prev)
     */
    static void myDeleteDups(Node head) { //with no prev
        Set<Integer> values = new HashSet<>();
        Node n = head;
        values.add(n.data);

        while (n.next != null) {
            if (values.contains(n.next.data)) {
                n.next = n.next.next; //n.next = n.next.next will do the necessary iteration
            } else {
                values.add(n.next.data);
                n = n.next; //this will bring you to latest state anyways.
            }
        }
    }

    @Deprecated
    static void deleteDupsNoBuffer(Node head) {
        Node p1 = head;
        Node p2;
        Node prev;

        while (p1.next != null) {
            int data = p1.data;
            p2 = p1.next;
            prev = p1;

            while (p2 != null) {
                if (p2.data == data) {
                    prev.next = p2.next;
                } else {
                    prev = p2;
                }
                p2 = p2.next;
            }
//            if (p1.next != null)
            p1 = p1.next;
        }
    }

    /**
     * Nice one
     */
    static void deleteDupsNoBufferMain(Node head) {
        Node n = head;
        Node r = n;

        while (n != null) { //you can go till the end but the second while() will not work anywayss
            r = n;
            while (r.next != null) { //work with next val that is why check for next !=null
                if (r.next.data == n.data) {
                    r.next = r.next.next;
                } else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }
}
