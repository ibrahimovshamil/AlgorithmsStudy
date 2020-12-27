package chapter2;

public class Q2FindKth {


    public static void main(String[] args) {
        Node head = createLinkedList();
//        printKth(head, 1);
//        System.out.println(getKth(head, 2).data);
        System.out.println(nThToLast(head, 2));
    }

    static Node createLinkedList() {
        Node head = new Node(0);
        head.appendToTail(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(5);
        head.appendToTail(6);
        return head;
    }

    //Doesn't Return element
    static int printKth(Node head, int k) {
        if (head == null)
            return 0;
        int val = printKth(head.next, k);
        if (val == k)
            System.out.println(head.data + " " + val);
        val = val + 1;
        return val;
    }

    /**
     * Nice One
     * Returns Node and mimics pass by reference by OBJ
     */
    static Node getKth(Node head, int k) {
        Index index = new Index();
        return getKth(head, k, index);
    }

    static Node getKth(Node head, int k, Index index) {
        if (head == null)
            return null;

        Node nd = getKth(head.next, k, index);
        index.value = index.value + 1; //has to be before if o/w value will never change and it will cause to return new head all the time
        if (k == index.value)
            return head;
        return nd;
    }

    static class Index {
        public int value = 0;
    }

    /**
     * The more optimal one
     */
    static Node nThToLast(Node head, int k) {
        Node p1 = head;
        Node p2 = head;

        for (int i = 0; i < k; i++) {
            if (p1 == null)
                return null;
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}
