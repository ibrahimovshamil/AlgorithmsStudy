package chapter2;

public class Q4Partition {
    public static void main(String[] args) {
        Node head = createLinkedList();
//        head.print();
//        partitionBook(head, 5);
        partitionBetter(head, 5);
//        head.print();
//        head.print();
    }

    static Node createLinkedList() {
        Node head = new Node(0);
        head.appendToTail(3);
        head.appendToTail(5);
        head.appendToTail(8);
        head.appendToTail(10);
        head.appendToTail(2);
        head.appendToTail(1);
        return head;
    }

    /*Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
     Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
     smallStart
     bigStart
     */
    public static Node partition(Node head, int x) {
        Node smallStart = null;
        Node smallEnd = null;
        Node bigStart = null;
        Node bigEnd = null;
        Node n = head;

        while (n != null) {
            if (n.data >= x) {
                if (bigStart == null) {
                    bigStart = n;
                    bigEnd = bigStart;
                } else {
                    bigEnd.next = n;
                    bigEnd = bigEnd.next;
                }
                n = n.next; // to not loose the value
                bigEnd.next = null;
            } else {
                if (smallStart == null) {
                    smallStart = n;
                    smallEnd = smallStart;
                } else {
                    smallEnd.next = n;
                    smallEnd = smallEnd.next;
                }
                n = n.next;
                smallEnd.next = null;
            }
        }

        if (smallStart == null) {
            return bigStart;
        }

        smallEnd.next = bigStart;
        return smallStart;
    }

    public static Node ret(Node head) {
        Node n = head;
        n.next = null;
        return head;
    }

    static Node partitionBook(Node node, int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        /*Partition list*/
        while (node != null) {
            Node next = node.next;
            node.next = null;
            if (node.data < x) {
                if /*Insert node into end of before list*/
                (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
                beforeEnd.next = node;
                beforeEnd = node;
            } else {
                /*Insert node into end of after list*/
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }


        if (beforeStart == null) {
            return afterStart;
        }

        /* Merge before list and after list */
        beforeEnd.next = afterStart;
        return beforeStart;
    }

    static Node partitionBetter(Node node, int x) {
        Node head = node;
        Node tail = node;

        while (node != null) {
            Node next = node.next; // to keep the value
            if (node.data < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }

        tail.next = null;
        return head;
    }
}
