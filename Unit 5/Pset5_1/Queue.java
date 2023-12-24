import java.util.ArrayList;

/*
 * Sam Sah-Nixon
 * Date Created: 2/10/23
 * Last Modified: 2/10/23
 * Description: A Queue created using an array list
 */
public class Queue<E extends Comparable<? super E>> implements MyQueue<E>{
    
    private ArrayList<E> list;
    
    public Queue(){
        list = new ArrayList<E>();
    }
    
    /**
     * Adds a new item to the end of the list making it the last item in the collection.
     * @param item The Item to add
     */
    public void enQueue(E item) {
        list.add(list.size(), item);
    }
    
    /**
     * Removes and returns the first item in the list
     * @return The item removed
     */
    public E deQueue() {
        return list.remove(0);
    }

    /**
     * Tests to see whether the list is empty.
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * Returns the first item in the list
     * @return the first item in the list
     */
    public E front() {
        return list.get(0);
    }

    
    /**
     * Returns the number of items in the list.
     * @return the size
     */
    public int size() {
        return list.size();
    }

    /**
     * Returns a string representation of the list.
     * @return a string representation of the list
     */
    public String toString() {
        return list.toString();
    }
}