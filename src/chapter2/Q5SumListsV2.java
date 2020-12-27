package chapter2;

public class Q5SumListsV2 {
    public static void main(String[] args) {
        Node l1 = new Node(6);
        l1.appendToTail(5).appendToTail(7);
        Node l2 = new Node(7);
        l2.appendToTail(9).appendToTail(5   );

        addListsV2(l1, l2).print();
    }

    /**
     * Good one. Used a helper which helped us to use A Wrapper class which holds value of a carry and a Node.
     * Helper function helped us to handle edge case which is when the carry is bigger one when in the last returned call
     */

    public static Node addListsV2(Node l1, Node l2) {
        int length1 = getLength(l1);
        int length2 = getLength(l2);

        if (length2 < length1)
            l2 = slide(l2, length1 - length2);
        else if (length1 < length2)
            l1 = slide(l2, length2 - length1);

        SumNode newSumNode = new SumNode();
        //I dont actually use newSumNode in my prams since i already wrap it with return type.
        SumNode newReturnedSumNode = addListsHelper(l1, l2, newSumNode);

        if (newSumNode.carry == 0)
            return newReturnedSumNode.node;

        return insertToHead(newReturnedSumNode.node, newSumNode.carry);
    }

    public static SumNode addListsHelper(Node l1, Node l2, SumNode sumNode) {
        if (l1 == null) {
            return new SumNode();
        }

        SumNode returnedSumNode = addListsHelper(l1.next, l2.next, sumNode);
        Node newNode = new Node(0);

        int total = l1.data + l2.data + sumNode.carry;
        if (total > 9) {
            sumNode.carry = 1;
            total = total % 10;
        } else {
            sumNode.carry = 0;
        }

        newNode.data = total;
        newNode.next = returnedSumNode.node;
        returnedSumNode.node = newNode;

        return returnedSumNode;
    }

    public static Node slide(Node l, int numberOfSlides) {
        Node newHead = l;
        for (int i = 0; i < numberOfSlides; i++)
            newHead = insertToHead(newHead, 0);
        return newHead;
    }

    public static Node insertToHead(Node list, int val) {
        Node newHead = new Node(val);
        newHead.next = list;
        return newHead;
    }

    public static int getLength(Node l) {
        int length = 0;
        while (l != null) {
            length++;
            l = l.next;
        }
        return length;
    }

    static class SumNode {
        int carry = 0;
        Node node;
    }
}
