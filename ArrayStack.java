public class ArrayStack<T> implements MyStack<T> {
    private int size = 0;
    private T[] stack = (T[]) new Object [10];
    private int top = 0;

    @Override
    public void push(T item) {
        if (size == stack.length - 1){resize();}
        stack[top] = item;
        top = (top + 1) % stack.length;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("empty stack");
        }
        top = (top - 1) % stack.length;
        T first = stack[top];
        size--;
        return first;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("empty stack");
        }
        return stack[top - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void resize(){
        T[] newstack = (T[]) new Object [stack.length * 2];
        for (int i = 0; i < stack.length; i++){
            newstack[i] = stack[i % stack.length];
        }
        top = size;
        stack = newstack;
    }
    
}
