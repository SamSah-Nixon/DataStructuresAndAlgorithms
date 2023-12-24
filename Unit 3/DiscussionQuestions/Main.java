import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        list.add('P');
        list.add('Y');
        list.add('T');
        list.add('H');
        list.add('O');
        list.add('N');
        System.out.println(shellSort(list));
    }
    // Selection Sort with arrayList
    public static ArrayList<Integer> selectionSort(ArrayList<Integer> list){
        int minIndex, temp;
        //Goes through all the elements in the array. 
        //Each loop finds the smallest element in the array and puts it in the correct place
        for (int i = 0; i < list.size() - 1; i++) {
            minIndex = i;
            //Goes through all elements and finds the smallest to put into the array
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            temp = list.get(i);
            list.set(i,list.get(minIndex));
            list.set(minIndex,temp);
            System.out.println(list);
        }
        return list;
    }
    // Insertion sort with arrayList
    //Insertion sort
    //Time Complexity: O(n^2)
    public static void insertionSort(ArrayList<Integer> array){
        int temp;
        for(int i=1;i<array.size();i++){
            for(int j=i;j>0;j--){
                if(array.get(j)<array.get(j-1)){
                    temp=array.get(j);
                    array.set(j,array.get(j-1));
                    array.set(j-1,temp);
                }
            }
            System.out.println(array);
        }
    }
    public static void quickSort(ArrayList<Integer> list){
        quickSort(list, 0, list.size() - 1);
    }
    public static void quickSort(ArrayList<Integer> list, int first, int last){
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            System.out.println(pivotIndex);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }
    public static int partition(ArrayList<Integer> list, int first, int last){
        int pivot = list.get(first);
        int low = first + 1;
        int high = last;
        System.out.println(list);
        while (high > low) {
            while (low <= high && list.get(low) <= pivot) {
                low++;
            }
            while (low <= high && list.get(high) > pivot) {
                high--;
            }
            if (high > low) {
                int temp = list.get(high);
                list.set(high, list.get(low));
                list.set(low, temp);
            }
        }
        while (high > first && list.get(high) >= pivot) {
            high--;
        }
        if (pivot > list.get(high)) {
            list.set(first, list.get(high));
            list.set(high, pivot);
            return high;
        }
        else{
            return first;
        }
    }
    //Bubble Sort
    //Time Complexity: O(n^2)
    public static void bubbleSort(int[] array){
        int temp;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1;j++){
                if(array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
                System.out.println(Arrays.toString(array));
            }
        }
    }
    public static ArrayList<Character> shellSort(ArrayList<Character> array){
        char temp;
        for(int gap=array.size()/2;gap>0;gap/=2){
            for(int i=gap;i<array.size();i++){
                for(int j=i;j>=gap;j-=gap){
                    if(array.get(j)<array.get(j-gap)){
                        temp=array.get(j);
                        array.set(j,array.get(j-gap));
                        array.set(j-gap,temp);
                    }
                }
                System.out.println(array);
            }
        }
        return array;
    }
}