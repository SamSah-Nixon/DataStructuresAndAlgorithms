import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args){

        ArrayList<Integer> arr = new ArrayList<Integer>();
        Collections.addAll(arr, 51, 793, 4, 193, 355, 9, 24, 915, 2, 8, 86, 67);
        arr = Radix.radixSort1(arr);
        System.out.println("Array 1: "+arr);
        arr = new ArrayList<Integer>();
        Collections.addAll(arr, 170, 45, 75, 90, 802, 24, 2, 66 , 1, 2, 3, 4, 5, 10 ,11, 12, 13, 101, 102, 103);
        arr = Radix.radixSort2(arr);
        System.out.println("Array 2: "+arr);

        Deque<Integer> deque = new Deque<>();
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);
        deque.addBack(4);
        deque.addBack(5);
        deque.addBack(6);
        System.out.print("\nDeque: ");
        System.out.print(deque.removeFront()+" ");
        System.out.print(deque.removeFront()+" ");
        System.out.print(deque.removeFront()+" ");
        System.out.print(deque.removeFront()+" ");
        System.out.print(deque.removeBack()+" ");
        System.out.print(deque.removeBack()+" ");
        
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.print("\nQueue: ");
        System.out.print(queue.deQueue()+ " ");
        System.out.print(queue.deQueue()+ " ");
        System.out.print(queue.deQueue()+ " ");
        System.out.print(queue.deQueue()+ " ");

        
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.print("\nStack: ");
        System.out.print(stack.peek()+ " ");
        System.out.print(stack.pop()+ " ");
        System.out.print(stack.peek()+ " ");
        System.out.print(stack.pop()+ " ");
        System.out.print(stack.peek()+ " ");
        System.out.print(stack.pop()+ " ");
        System.out.print(stack.peek()+ " ");
        System.out.print(stack.pop()+ " ");
        
    }
}