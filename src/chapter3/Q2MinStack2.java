package chapter3;

import java.util.Stack;

/**
 * Creating our new Stack by extending the original one and add a new member (Stack s2) to have a other stack to keep min val
 */
public class Q2MinStack2 extends Stack<Integer> {
    Stack<Integer> s2;

    public Q2MinStack2() {
        s2 = new Stack<>();
    }

    public void push(int val) {
        super.push(val);
        if (val <= s2.peek())
            s2.push(val);
    }

    public Integer pop() {
        int popped = super.pop();
        if (popped == min()) // it cannot be smaller than the min val
            s2.pop();
        return popped;
    }

    public int min() {
        if (s2.empty())
            return Integer.MAX_VALUE;
        return s2.peek();
    }

}
