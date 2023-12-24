import java.util.ArrayList;
import java.util.Collections;

public class Radix {

    // Radix sort algorithm
    // Time complexity: O(nk) where k is the number of digits in the largest number
    // Determine the number of digits in the largest number
    // Start from the least significant digit and sort the numbers based on that digit
    // Move on to the next least significant digit and repeat the process
    // Repeat until the most significant digit is reached
    // The list is now sorted

    public static ArrayList<Integer> radixSort1(ArrayList<Integer> arr) {
        //Calculate the number of digits in the largest number
        int max = (int) Math.log10(Collections.max(arr)) + 1;

        //For every digit in the number
        for (int i = 0; i < max; i++) {
            //Declare and Initialize a bucket for each digit
            Queue<Integer>[] buckets = new Queue[10];
            for (int j = 0; j < 10; j++)
                buckets[j] = new Queue<Integer>();

            //Put the numbers in the correct bucket
            for (int a : arr) {
                buckets[(int)(a / Math.pow(10, i)) % 10].enQueue(a);
            }

            //Put the numbers back into the array
            arr = new ArrayList<Integer>();
            for (Queue<Integer> queue : buckets) {
                while (!queue.isEmpty()) {
                    arr.add(queue.deQueue());
                }
            }
        }
        return arr;
    }

    public static ArrayList<Integer> radixSort2(ArrayList<Integer> arr) {
        // Find the maximum number to know number of digits
        int max = arr.get(0);
        for (int i = 1; i < arr.size(); i++)
            if (arr.get(i) > max)
                max = arr.get(i);
        
            
        // For every digit in the number
        for (int exp = 1; max / exp > 0; exp *= 10){
            //Counts where the numbers should go
            int[] count = new int[10];
            //Where the numbers will go
            ArrayList<Integer> output = new ArrayList<Integer>();
            for (int i = 0; i < arr.size(); i++)
                output.add(0);
            // Store count of each digit in count array
            for (int i = 0; i < arr.size(); i++)
                count[(arr.get(i) / exp) % 10]++;
            // Change count so that count now contains actual position of this digit in output
            for (int i = 1; i < 10; i++)
                count[i] += count[i - 1];
            // Build the output array
            for (int i = arr.size() - 1; i >= 0; i--) {
                output.set(count[(arr.get(i) / exp) % 10] - 1, arr.get(i));
                count[(arr.get(i) / exp) % 10] = count[(arr.get(i) / exp) % 10] - 1;
            }
 
            // Put output into arr
            for (int i = 0; i < arr.size(); i++)
                arr.set(i, output.get(i));
        }
        return arr;
    }
}