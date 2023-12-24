import java.util.ArrayList;

/*
 * Sam Sah-Nixon
 * Created: 2/10/23
 * Last Modified: 2/10/23
 * A Stack created using an array list
 */
public class ListStack<E extends Comparable<? super E>> implements MyStack<E>{

    private ArrayList<E> list;

    public ListStack() {
        list = new ArrayList<E>();
    }
    
    /**
     * Adds an element to the front of the list if it doesn't already exist.
     * @param info The element to add.
     */
    public void push(E obj) {
        list.add(0, obj);
    }

    /**
     * Removes the first element in the list
     * @return The element that was removed.
     */
    public E pop(){
        return list.remove(0);
    }

    /**
     * Returns the first element in the list.
     * @return The first element in the list.
     */
    public E peek() {
        return list.get(0);
    }

    /**
     * Returns the size of the list.
     * @return The size of the list.
     */
    public int size() {
        return list.size();
    }
    
    /**
     * Returns whether the list is empty.
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * Returns a string representation of the list.
     * @return A string representation of the list.
     */
    public String toString() {
        return list.toString();
    }
}