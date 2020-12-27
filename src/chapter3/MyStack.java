package chapter3;

public class MyStack<D> {
    private class StackNode<T> {
        private T data;
        private StackNode<T> next;

        private StackNode(T data) {
            this.data = data;
        }

    }

    private StackNode<D> top;

    public D pop() {
        if (top == null)
            System.out.println("Stack is empty. Cannot pop");
        D data = top.data;

        top = top.next;
        return data;
    }

    public void push(D item) {
        StackNode<D> node = new StackNode<>(item);
        node.next = top;
        top = node;
    }

    public D peek() {
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }


}
