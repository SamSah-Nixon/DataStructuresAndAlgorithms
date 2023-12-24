import java.util.ArrayList;
import java.util.Collections;
public class Main{
    public static void main(String[] args) {
        System.out.println("Sorting...\nOut of 10 attempts from each sort:");
        TimeTrial trial;
        ArrayList<Integer> arr;
        //Loops through 6 times. One for each sorting method
        for(int i=0;i<6;i++){
            trial = new TimeTrial(10);
            //Tries each method 10 times and records the average
            //Checks which print statement to say depending on which sort it is doing
            switch (i){
                case 0:
                    System.out.print("Average BUBBLE Sort: ");
                    break;
                case 1:
                    System.out.print("Average INSERTION Sort: ");
                    break;
                case 2:
                    System.out.print("Average SELECTION Sort: ");
                    break;
                case 3:
                    System.out.print("Average MERGE Sort: ");
                    break;
                case 4:
                    System.out.print("Average QUICK Sort: ");
                    break;
                case 5:
                    System.out.print("Average SHELL Sort: ");
                    break;
            }
            for(int j=0;j<10;j++){
                arr = randomArray(10000);
                trial.setStartRunTime(System.nanoTime());
                //Checks which sorting algorithm to use
                switch (i) {
                    case 0:
                        bubbleSort(arr);
                    case 1: 
                        insertionSort(arr);
                        break;
                    case 2:
                        selectionSort(arr);
                        break;
                    case 3:
                        mergeSort(arr);
                        break;
                    case 4:
                        quickSort(arr);
                        break;
                    case 5:
                        shellSort(arr);
                        break;
                    }
                trial.endTimeTrial(j);
                }
                //Prints result average
                System.out.println(TimeTrial.round(trial.average(), 7)+" milliseconds");
            }
        }
    //Function to make a random unordered arraylist
    public static ArrayList<Integer> randomArray(int length){
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i=0;i<length;i++){
            array.add((int)(Math.random()*length));
        }
        return array;
    }
    //Bubble sort
    //Time Complexity: O(n^2)
    public static void bubbleSort(ArrayList<Integer> array){
        int temp;
        for(int i=0;i<array.size();i++){
            for(int j=0;j<array.size()-1;j++){
                if(array.get(j)>array.get(j+1)){
                    temp=array.get(j);
                    array.set(j,array.get(j+1));
                    array.set(j+1,temp);
                }
            }
        }
    }
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
        }
    }
    //Selection sort
    //Time Complexity: O(n^2)
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
            list.set(minIndex,list.get(temp));
        }
        return list;
    }
    //Merge sort
    //Time Complexity: O(nlogn)
    public static void mergeSort(ArrayList<Integer> array){
        if(array.size()>1){
            ArrayList<Integer> left = new ArrayList<Integer>();
            ArrayList<Integer> right = new ArrayList<Integer>();
            for(int i=0;i<array.size()/2;i++){
                left.add(array.get(i));
            }
            for(int i=array.size()/2;i<array.size();i++){
                right.add(array.get(i));
            }
            mergeSort(left);
            mergeSort(right);
            merge(array,left,right);
        }
    }
    public static void merge(ArrayList<Integer> array,ArrayList<Integer> left,ArrayList<Integer> right){
        int leftIndex = 0;
        int rightIndex = 0;
        int overallIndex = 0;
        while(leftIndex<left.size()&&rightIndex<right.size()){
            if(left.get(leftIndex)<right.get(rightIndex)){
                array.set(overallIndex,left.get(leftIndex));
                leftIndex++;
            }else{
                array.set(overallIndex,right.get(rightIndex));
                rightIndex++;
            }
            overallIndex++;
        }
        while(leftIndex<left.size()){
            array.set(overallIndex,left.get(leftIndex));
            leftIndex++;
            overallIndex++;
        }
        while(rightIndex<right.size()){
            array.set(overallIndex,right.get(rightIndex));
            rightIndex++;
            overallIndex++;
        }
    }
    //Quick sort
    //Time Complexity: O(nlogn)
    public static void quickSort(ArrayList<Integer> array){
        quickSort(array,0,array.size()-1);
    }
    public static void quickSort(ArrayList<Integer> array,int low,int high){
        if(low<high){
            int pivot = partition(array,low,high);
            quickSort(array,low,pivot-1);
            quickSort(array,pivot+1,high);
        }
    }
    public static int partition(ArrayList<Integer> array,int low,int high){
        int pivot = array.get(high);
        int i = low-1;
        int temp;
        for(int j=low;j<high;j++){
            if(array.get(j)<pivot){
                i++;
                temp=array.get(i);
                array.set(i,array.get(j));
                array.set(j,temp);
            }
        }
        temp=array.get(i+1);
        array.set(i+1,array.get(high));
        array.set(high,temp);
        return i+1;
    }
    //Shell sort
    //Time Complexity: O((nlogn)^2)
    public static void shellSort(ArrayList<Integer> array){
        int temp;
        for(int gap=array.size()/2;gap>0;gap/=2){
            for(int i=gap;i<array.size();i++){
                for(int j=i;j>=gap;j-=gap){
                    if(array.get(j)<array.get(j-gap)){
                        temp=array.get(j);
                        array.set(j,array.get(j-gap));
                        array.set(j-gap,temp);
                    }
                }
            }
        }
    }
}