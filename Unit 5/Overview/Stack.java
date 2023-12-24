/*
 * Sam Sah-Nixon
 * Created: 2/6/23
 * Last Modified: 2/6/23
 * A Stack created using a singly linked list
 */
public class Stack<E extends Comparable<? super E>>{

    private LocalNode<E> head;
    private int size;

    public Stack() {
        head = new LocalNode<E>();
        size = 0;
    }

    private static class LocalNode<E> {
        private E info;
        private LocalNode<E> next;

        public LocalNode() {
            info = null;
            next = null;
        }
        public LocalNode(E obj, LocalNode<E> node) {
            info = obj;
            next = node;
        }
    }
    
    /**
     * Adds an element to the front of the list if it doesn't already exist.
     * @param info The element to add.
     */
    public void push(E obj) {
        if(isEmpty())
            head.next = new LocalNode<E>(obj, null);
        else {
            LocalNode<E> previous = head.next;
            head.next = new LocalNode<E>(obj,previous);
        }
        size++;
    }

    /**
     * Removes the first element in the list
     * @return The element that was removed.
     */
    public E pop(){
        if(isEmpty())
            return null;
        LocalNode<E> current = head.next;
        head.next = current.next;
        current.next = null;
        size--;
        return current.info;
    }

    /**
     * Returns the first element in the list.
     * @return The first element in the list.
     */
    public E peek() {
        if(isEmpty())
            return null;
        return head.next.info;
    }

    /**
     * Returns the size of the list.
     * @return The size of the list.
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns whether the list is empty.
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a string representation of the list.
     * @return A string representation of the list.
     */
    public String toString() {
        String result = "";
        LocalNode<E> current = head.next;
        while(current != null) {
            result += current.info + " ";
            current = current.next;
        }
        return result;
    }
}