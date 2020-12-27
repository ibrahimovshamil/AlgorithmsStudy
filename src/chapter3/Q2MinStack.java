package chapter3;

import java.util.Stack;

/**
 * We are inserting our desired data type into our extended Stack
 */
public class Q2MinStack extends Stack<Q2MinStack.StackNodeWithMin> {


    public void push(int item) {
        StackNodeWithMin node;
        if (item < min())
            node = new StackNodeWithMin(item, item);
        else {
            node = new StackNodeWithMin(min(), item);
        }
        super.push(node);

        //or
//        int min = Math.min(item, min());
//        super.push(new StackNodeWithMin(min, item));

    }

    public int min() {
        if (this.empty())
            return Integer.MAX_VALUE;

        return this.peek().min;
    }

    protected class StackNodeWithMin {
        int min;
        int data;

        public StackNodeWithMin(int min, int data) {
            this.min = min;
            this.data = data;
        }
    }
}
