/*
 * Sam Sah-Nixon
 * Date Created: 2/10/23
 * Last Modified: 2/16/23
 * Description: A Deque created using a linked list.
 */
public class Deque<E extends Comparable<? super E>> implements MyDeque<E>{
    
    private UnorderedList<E> list;
    
    public Deque(){
        list = new UnorderedList<E>();
    }

    /**
     * Adds a new item to the beginning of the list.
     * @param item The Item to add
     */
    public void addFront(E item) {
        list.add(item);
    }

    /**
     * Adds a new item to the end of the list making it the last item in the collection.
     * @param item The Item to add
     */
    public void addBack(E item) {
        list.append(item);
    }
    
    /**
     * Removes and returns the first item.
     * @return The item removed
     */
    public E removeFront(){
        return list.pop();
    }

    /**
     * Removes and returns the last item.
     * @return The item removed
     */
    public E removeBack() {
        return list.popRear();
    }

    /**
     * Tests to see whether the list is empty.
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns the first item in the list
     * @return the first item in the list
     */
    public E front() {
        return list.front();
    }

    /**
     * Returns the last item in the list.
     * @return last item in the list
     */
    public E back() {
        return list.valueAt(list.size() - 1);
    }
    
    /**
     * Returns the number of items in the list.
     * @return the size
     */
    public int size() {
        return list.size();
    }

    public String toString() {
        return list.toString();
    }
}