import java.util.ArrayList;

public class QuickSort {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(64);
        list.add(34);
        list.add(25);
        list.add(12);
        list.add(52);
        list.add(41);
        list.add(11);
        list.add(87);
        list.add(5);
        list.add(4);
        list.add(90);
        System.out.println(quickSort(list));
    }
    //Quick sort method
    public static ArrayList<Integer> quickSort(ArrayList<Integer> list){
        return quickSort(list, 0, list.size() - 1);
    }
    //Quick sort method
    public static ArrayList<Integer> quickSort(ArrayList<Integer> list, int first, int last){
        if(last > first){
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
        return list;
    }
    //Partition the array list
    public static int partition(ArrayList<Integer> list, int first, int last){
        int pivot = list.get(first);
        int low = first + 1;
        int high = last;
        while(high > low){
            //Search forward from left
            while(low <= high && list.get(low) <= pivot)
                low++;
            //Search backward from right
            while(low <= high && list.get(high) > pivot)
                high--;
            //Swap two elements in the list
            if(high > low){
                int temp = list.get(high);
                list.set(high, list.get(low));
                list.set(low, temp);
            }
        }
        while(high > first && list.get(high) >= pivot)
            high--;
        //Swap pivot with list[high]
        if(pivot > list.get(high)){
            list.set(first, list.get(high));
            list.set(high, pivot);
            return high;
        }
        else{
            return first;
        }
    }
}
//64 34 25 12 52 41 11 87 5 4 90
//Choose a pivot point
//Usually the first or last element
//Partition the list to find the split point
//Traverse the list with front and end values
//Swap the values if the front value is greater than the pivot
//Swap the pivot with the split point
//Repeat the process for the left and right sublists
// O(n^2) worst case O(nlogn) best case O(nlogn) average case