/*
 * Sam Sah-Nixon
 * Date Created: 2/6/23
 * Last Modified: 2/6/23
 * Description: A Deque created using a doubly linked list
 */
public class Deque<E extends Comparable<? super E>>{
    
    private DoubleNode<E> head;
    private int size;
    
    public Deque(){
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
     * Adds a new item to the beginning of the list.
     * @param item The Item to add
     */
    public void addFront(E item) {
        head.next = new DoubleNode<E>(item, null, head.next);
        if(head.next.next != null)
            head.next.next.prev = head.next;
        else
            head.prev = head.next;
        size++;
    }

    /**
     * Adds a new item to the end of the list making it the last item in the collection.
     * @param item The Item to add
     */
    public void addBack(E item) {
        head.prev.next = new DoubleNode<E>(item, head.prev, null);
        head.prev = head.prev.next;
        size++;
    }
    
    /**
     * Removes and returns the first item.
     * @return The item removed
     */
    public E removeFront(){
        DoubleNode<E> current = head.next;
        head.next = current.next;
        if(current.next != null)
            current.next.prev = null;
        else
            head.prev = null;
        //Disconnect Node
        current.prev = null;
        current.next = null;
        size--;
        return current.info;
    }

    /**
     * Removes and returns the last item.
     * @return The item removed
     */
    public E removeBack() {
        DoubleNode<E> current = head.prev;
        head.prev = current.prev;
        if(current.prev != null)
            current.prev.next = null;
        else
            head.next = null;
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
     * Returns the last item in the list.
     * @return last item in the list
     */
    public E rear() {
        return head.prev.info;
    }
    
    /**
     * Returns the number of items in the list.
     * @return the size
     */
    public int size() {
        return size;
    }
}