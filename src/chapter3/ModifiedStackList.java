package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ModifiedStackList {

    List<ModifiedStack> stacks = new ArrayList<>();
    int capacity;

    public ModifiedStackList(int capacity) {
        this.capacity = capacity;
    }

    public void push(int item) {
        ModifiedStack last = getLast();
        if (null != getLast() && !isFull()) {
            last.push(item);
            last.size++;
        } else {
            ModifiedStack stack = new ModifiedStack(capacity);
            stack.push(item);
            stack.size++;
            stacks.add(stack);
        }
    }

    /**
     * @param index is a specific stack
     */
    public void pop(int index) {
        if (index > stacks.size()) throw new IndexOutOfBoundsException();
        shift(index);
    }

    private int shift(int index) {
        if (index > stacks.size() - 1)
            return 0;
        ModifiedStack stack = stacks.get(index);
        int item = stack.pop();
        push(shift(index++));
        return item;
    }

    private boolean isFull() {
        ModifiedStack last = getLast();
        return last.size == capacity;
    }

    public ModifiedStack getLast() {
        if (stacks.size() == 0) return null;
        ModifiedStack last = stacks.get(stacks.size() - 1);
        return last;
    }

}
