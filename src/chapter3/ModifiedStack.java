package chapter3;

import java.util.Stack;

public class ModifiedStack extends Stack<Integer> {
    int capacity;
    int size = 0;

    public ModifiedStack(int capacity) {
        this.capacity = capacity;
    }
}
