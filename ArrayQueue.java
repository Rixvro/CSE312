public class ArrayQueue<T> implements MyQueue<T>{
    private int size = 0;
    private T[] queue = (T[]) new Object [10];
    private int front = 0;
    private int back = 0;

    @Override
    // Coded exactly like how the lecture ArrayQueue was coded - just filled in the gaps
    // wherever necessary 
    public void enqueue(T item) {
        if (size == queue.length - 1){resize();}
        queue[back] = item;
        back = (back + 1) % queue.length;
        size++;
    }

    @Override
    // Coded exactly like how the lecture ArrayQueue was coded - just filled in the gaps
    // wherever necessary 
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("empty stack");
        }
        T first = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return first;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("empty stack");
        }
        return queue[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Creates an array double the size of existing one
    // Clones array from wherever original "front" of the array is and reindexes them
    // Reset front to be index 0, set back to whatever the size is since that should be the end of the array.
    public void resize(){
        T[] newQueue = (T[]) new Object [queue.length * 2];
        for (int i = 0; i < queue.length; i++){
            newQueue[i] = queue[(front + i) % queue.length];
        }
        front = 0;
        back = size;
        queue = newQueue;
    }
}
