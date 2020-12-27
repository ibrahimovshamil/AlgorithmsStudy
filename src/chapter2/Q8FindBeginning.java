package chapter2;

public class Q8FindBeginning {

    /**
     * By using fast and slow runners
     */
    public static Node findBeginning(Node n) {
        Node slow = n;
        Node fast = n;

        while (fast != null && fast.next != null) { // always good practise to test your FAST runner like this.
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        slow = n;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
