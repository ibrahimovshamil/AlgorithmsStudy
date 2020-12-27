package chapter2;

public class Q6Polindrome {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.appendToTail(2).appendToTail(2).appendToTail(1);
        Node reversed = reverseList(node);
        reversed.print();
        System.out.println(isEqual(node, reversed));
    }

    public static Node reverseList(Node head) {
        Node newNode = null;
        while (head != null) {
            Node n = new Node(head.data);
            n.next = newNode;
            newNode = n;
            head = head.next;
        }
        return newNode;
    }

    public static Node reverseListV2(Node head) {
        Node newNode = new Node(head.data);
        newNode.next = null;
        Node cur = newNode;
        head = head.next;
        while (head != null) {
            Node n = new Node(head.data);
            n.next = cur;
            cur = n;
            head = head.next;
        }

        return cur;
    }

    public static boolean isEqual(Node l1, Node l2) {
        while (l1 != null && l2 != null) {
            if (l1.data != l2.data)
                return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null)
            return true;
        else return false;
    }

}
