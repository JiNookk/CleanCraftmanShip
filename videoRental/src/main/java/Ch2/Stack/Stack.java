package Ch2.Stack;

public class Stack {
    private int size = 0;
    private int[] elements = new int[2];

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int element) {
        this.elements[size] = element;
        size += 1;
    }

    public int pop() {
        if (size == 0) {
            throw new UnderflowException();
        }

        size -= 1;
        return elements[size];
    }

    public int getSize() {
        return size;
    }
}
