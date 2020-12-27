package chapter2;

import java.util.Stack;

public class Q6PolindromeV2 {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.appendToTail(2).appendToTail(2).appendToTail(1);
        System.out.println(isPolindrome(node));
    }

    public static boolean isPolindrome(Node head) {
        Node slow = head;
        Node fast = head;

        Stack<Integer> stack = new Stack<>();

        //be careful about when this "while" works and we push into a stack. when it is odd we don't push it for eg.
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null)
            slow = slow.next;

        while (slow != null) {
            int val = stack.pop();
            if (val != slow.data)
                return false;
            slow = slow.next;
        }
        return true;
    }
}
