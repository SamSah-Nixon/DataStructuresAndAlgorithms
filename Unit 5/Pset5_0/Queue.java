/*
 * Sam Sah-Nixon
 * Date Created: 2/6/23
 * Last Modified: 2/6/23
 * Description: A Queue created using a doubly linked list
 */
public class Queue<E extends Comparable<? super E>>{
    
    private DoubleNode<E> head;
    private int size;
    
    public Queue(){
        head = new DoubleNode<E>();
        size = 0;
    }

    private static class DoubleNode<E>{
        private E info;
        private DoubleNode<E> prev;
        private DoubleNode<E> next;

        public DoubleNode(){
            info = null;
            prev = null;
            next = null;
        }
        public DoubleNode(E info, DoubleNode<E> prev, DoubleNode<E> next){
            this.info = info;
            this.prev = prev;
            this.next = next;
        }
    }
    
    /**
     * Adds a new item to the end of the list making it the last item in the collection.
     * @param item The Item to add
     */
    public void enqueue(E item) {
        if(isEmpty()){
            head.next = new DoubleNode<E>(item, null, null);
            head.prev = head.next;
        }
        else{
            head.prev.next = new DoubleNode<E>(item, head.prev, null);
            head.prev = head.prev.next;
        }
        size++;
    }
    
    /**
     * Removes and returns the first item in the list
     * @return The item removed
     */
    public E dequeue() {
        if(isEmpty())
            return null;
        DoubleNode<E> current = head.next;
        head.next = current.next;
        if(current.next != null)
            current.next.prev = null;
        else
            head.prev = null;
        head.prev = current.prev;
        //Disconnect Node
        current.prev = null;
        current.next = null;
        size--;
        return current.info;
    }

    /**
     * Tests to see whether the list is empty.
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * Returns the first item in the list
     * @return the first item in the list
     */
    public E front() {
        return head.next.info;
    }

    
    /**
     * Returns the number of items in the list.
     * @return the size
     */
    public int size() {
        return size;
    }
}