/*
 * Sam Sah-Nixon
 * Created: 2/14/23
 * Last Modified: 2/14/23
 * A Queue that uses a LinkedList to store its data
 */
public class ListQueue<E extends Comparable<? super E>> implements MyQueue<E>{
    
    private UnorderedList<E> list;

    public ListQueue() {
        list = new UnorderedList<E>();
    }

    /**
     * Removes and returns the first item in the list
     * @return The item removed or null if the list is empty
     */
    public E deQueue() {
        return list.pop();
    }

    /**
     * Adds the item to the end of the list
     * @param item The item to add
     */
    public void enQueue(E item) {
        list.append(item);
    }
    
    /**
     * gets the first item in the list
     * @return The first item in the list or null if the list is empty
     */
    public E front() {
        return list.front();
    }
    
    /**
     * Says whether the list is empty or not
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    /**
     * Returns the size of the list
     * @return The size of the list
     */
    public int size() {
        return list.size();
    }

    /**
     * Returns a string representation of the Queue
     * @return a string representation of the Queue
     */
    public String toString() {
        return list.toString();
    }
}
