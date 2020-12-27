package chapter2;

public class Question5SumLists {

    public static void main(String[] args) {
        Node l1 = createLinkedList(7);
        l1.appendToTail(1);
        l1.appendToTail(6);
        Node l2 = createLinkedList(5);
        l2.appendToTail(9);
        l2.appendToTail(2);

        addList(l1, l2, 0).print();
    }

    static Node createLinkedList(int val) {
        Node head = new Node(val);
//        head.appendToTail(1);
//        head.appendToTail(2);
//        head.appendToTail(3);
//        head.appendToTail(4);
//        head.appendToTail(5);
//        head.appendToTail(6);
        return head;
    }

    /**
     * Nice one
     */

    public static Node addList(Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null & carry == 0)
            return null;

        Node newNode = new Node(0);
        int l1Data = 0;
        int l2Data = 0;

        if (l1 != null)
            l1Data = l1.data;
        if (l2 != null)
            l2Data = l2.data;

        int result = l1Data + l2Data + carry;

        if (result > 9) {
            carry = 1;
            result = result % 10;
        } else carry = 0;

        newNode.data = result;

        Node l1Next = null;
        Node l2Next = null;
        if (l1 != null)
            l1Next = l1.next;
        if (l2 != null)
            l2Next = l2.next;

        Node returned = addList(l1Next, l2Next, carry);
        newNode.next = returned;

        return newNode;
    }
}

