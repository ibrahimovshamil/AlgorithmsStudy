package chapter3;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MyQueue<T> {
    private class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        private QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first; // head
    private QueueNode<T> last; // tail

    public void add(T item) {
        QueueNode node = new QueueNode(item);
        if (first == null && last == null) {
            node.next = first;
            first = node;
        } else {
            node.next = last;
        }
        last = node;
    }

    public T remove() {
        if (first == null)
            throw new NoSuchElementException();

        T data = first.data;
        first = first.next;
        return data;
    }

    public T peek() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
