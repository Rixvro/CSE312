public class LinkedStack<T> implements MyStack<T> {
    
    private static class ListNode<T>{
        private final T data;
        private ListNode<T> next;

        private ListNode(T data, ListNode<T> next){
            this.data = data;
            this.next = next;
        }

        private ListNode(T data){
            this.data = data;
        }
    }

    private ListNode<T> top;
    private int size = 0;

    @Override
    public void push(T item) {
        ListNode<T> newItem = new ListNode<T>(item,null);
        newItem.next = top;
        top = newItem;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("empty stack");
        }
        T topItem = top.data;
        top = top.next;
        size--;
        return topItem;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("empty stack");
        }
        return top.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
