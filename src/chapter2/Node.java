package chapter2;

public class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    Node appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
        return this;
    }

    void print() {
        Node tempHead = this;
        while (tempHead != null) {
            System.out.println(tempHead.data);
            tempHead = tempHead.next;
        }
    }
}