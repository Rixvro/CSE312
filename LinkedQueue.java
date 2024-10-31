public class LinkedQueue<E> implements MyQueue<E>{
    
    private static class ListNode<E>{
        private final E data;
        private ListNode<E> next;

        private ListNode(E data, ListNode<E> next){
            this.data = data;
            this.next = next;
        }

        private ListNode(E data){
            this.data = data;
        }
    }

    private ListNode<E> front;
    private ListNode<E> back;
    private int size = 0;

    @Override
    public void enqueue(E item) {
        if (front == null) { // If first item, make front store it
            front = new ListNode<E>(item, null);
            back = front;
            size++;
        } else { // Link new node to linked list
            ListNode<E> last = new ListNode<E>(item, null);
            back.next = last;
            back = last;
            size++;
        }
    }

    @Override
    public E dequeue() { // Drop the front node and reduce size
        if (isEmpty()) {
            throw new IllegalStateException("empty stack");
        }
        E first = front.data;
        front = front.next;
        size--;
        return first;
    }

    @Override
    public E peek() { // Check whats in front
        if (isEmpty()) {
            throw new IllegalStateException("empty stack");
        }
        return front.data;
    }

    @Override
    public int size() { 
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }
}
