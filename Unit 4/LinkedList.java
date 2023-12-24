public class LinkedList<E extends Comparable<? super E>> implements MyList<E> {

    private ListNode<E> head;
    private int size;

    public LinkedList() {
        head = new ListNode<E>();
        size = 0;
    }

    private static class ListNode<E> {
        private E info;
        private ListNode<E> next;

        public ListNode() {
            info = null;
            next = null;
        }
        public ListNode(E obj, ListNode<E> node) {
            info = obj;
            next = node;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E remove(E obj) {
        if(isEmpty())
            return null;
        ListNode<E> previous = head;
        ListNode<E> current = head.next;
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

    public void add(E obj) {
        if(isEmpty())
            head.next = new ListNode<E>(obj, null);
        else {
            ListNode<E> previous = head.next;
            head.next = new ListNode<E>(obj,previous);
        }
        size++;
        
    }

    public E front() {
        return head.next.info;
    }

    public int size() {
        return size;
    }   
    /**
     * Print the contents of the list
     */
    public void print() {
        ListNode<E> current = head.next;
        while(current != null) {
            System.out.println(current.info);
            current = current.next;
        }
    }
}
