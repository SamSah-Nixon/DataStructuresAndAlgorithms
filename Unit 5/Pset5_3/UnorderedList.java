import java.util.ArrayList;

/*
 * Sam Sah-Nixon
 * Created: 1/6/23
 * Last Modified: 1/9/23
 * A LinkedList with no order but now allow for duplicates and contains 2 extra functions.
 */
public class UnorderedList<E extends Comparable<? super E>> implements MyList<E>{

    private LocalNode<E> head;
    private int size;

    public UnorderedList() {
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
    public void add(E obj) {
        if(isEmpty()) {
            head.next = new LocalNode<E>(obj, null);
            size++;
            return;
        }
        LocalNode<E> previous = head.next;
        head.next = new LocalNode<E>(obj,previous);
        size++;
    }

    /**
     * Inserts an element at a given position in the list if it doesn't already exist.
     * @param pos The position to insert the element at.
     * @param info The element to insert.
     */
    public void insert(int pos, E info){
        LocalNode<E> current = head;
        int index = 0;
        while(current != null){
            if(index == pos){
                LocalNode<E> temp = current.next;
                current.next = new LocalNode<E>(info, temp);
                size++;
                return;
            }
            current = current.next;
            index++;
        }
    }

    /**
     * Appends an element to the end of the list if it doesn't already exist.
     * @param info The element to append.
     */
    public void append(E info){
        LocalNode<E> current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new LocalNode<E>(info, null);
        size++;
    }

    /**
     * Removes the first occurrence of an element from the list.
     * @param info The element to remove.
     * @return The element that was removed.
     */
    public E remove(E obj) {
        if(isEmpty())
            return null;
        LocalNode<E> previous = head;
        LocalNode<E> current = head.next;
        while(!current.info.equals(obj)) {
            previous = current;
            current = current.next;
            if (current == null)
                return null;
        }
        previous.next = current.next;
        current.next = null;
        size--;
        return current.info;
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
     * Removes all instances of an element from the list.
     * @param info The element to remove.
     */
    public void removeAll(E info) {
        if(isEmpty())
            return;
        while(contains(info)){
            remove(info);
        }
    }

    /**
     * Returns the index of the first instance of a given element in the list.
     * @param info The element to search for.
     * @return The index of the element, or -1 if it is not in the list.
     */
    public int indexOf(E info){
        if(isEmpty())
            return -1;
        LocalNode<E> current = head;
        int index = -1;
        while(current.next != null){
            current = current.next;
            index++;
            if(current.info.equals(info)){
                return index;
            }
        }
        return -1;
    }

    /**
     * Returns an ArrayList of all the indices of a given element in the list.
     * @param info The element to search for.
     * @return An ArrayList of all the indices of the element.
     */
    public ArrayList<Integer> indicesOf(E info){
        ArrayList<Integer> indices = new ArrayList<Integer>();
        if (isEmpty())
            return indices;
        LocalNode<E> current = head.next;
        int index = 0;
        while(current != null){
            if(current.info.equals(info)){
                indices.add(index);
            }
            current = current.next;
            index++;
        }
        return indices;
    }

    /**
     * Returns the element at a given position in the list.
     * @param pos The index of the element to return.
     * @return The element at the given position.
     */
    public E valueAt(int pos){
        LocalNode<E> current = head;
        int index = -1;
        while(current != null){
            if(index == pos){
                return current.info;
            }
            current = current.next;
            index++;
        }
        return null;
    }

    /**
     * Returns whether the list contains a given element.
     * @param item The element to search for.
     * @return True if the element is in the list, false otherwise or if it is empty.
     */
    public boolean contains(E item){
        if(isEmpty())
            return false;
        LocalNode<E> current = head.next;
        while(current != null){
            if(current.info.equals(item))
                return true;
            current = current.next;
        }
        return false;
    }

    /**
     * Returns the first element in the list.
     * @return The first element in the list.
     */
    public E front() {
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
     * Returns the list in a readable format string.
     * @return The list.
     */
    public String toString() {
        if(isEmpty())
            return "[]";
        LocalNode<E> current = head.next;
        String list = "[";
        while(current != null) {
            list += current.info + ", ";
            current = current.next;
        }
        // Remove the last comma and space
        list = list.substring(0, list.length() - 2);
        return list + "]";
    }
}