/*
Sam Sah-Nixon
Created: 12/05/22
Last Modified: 12/05/22
Runs and calculates the average times of recursive and iterative versions of the binary search algorithm
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int input=0,input2=0;
        //Try catch to make sure the user inputs an integer
        try{
            //Asks the user the length of the array to search and the number to search for
            System.out.println("Enter the length of the array list you want to search in");
            input = scanner.nextInt();
            System.out.println("Enter the number you want to search for");
            input2 = scanner.nextInt();
        }
        catch(Exception e){
            System.out.println("Please enter a valid positive integer");
        }
        if(input>0&&input2>0){
            searchTest(input, input2);
        }
    }
    public static void searchTest(int input, int input2) {
        //Create random ordered Arraylist
        ArrayList<Integer> list = generateOrderedArrayList(input);
        System.out.println("The number "+input2+" is "+ (binarySearchIt(list, input2)!=-1 ? "" : "not ") + "in the list");
        //Run the binary search trials and return the average time
        TimeTrial trial = new TimeTrial(1000);
        for(int i=0;i<1000;i++){
            trial.setStartRunTime(System.nanoTime());
            binarySearchIt(list, input2);
            trial.endTimeTrial(i);
        }
        double iterativeAverage = trial.round(trial.average(),7);
        System.out.println("Average Iterative Search Time: "+iterativeAverage+" milliseconds");
        //Run the sequential search trials and return the average time
        trial = new TimeTrial(1000);
        for(int i=0;i<1000;i++){
            trial.setStartRunTime(System.nanoTime());
            binarySearchRec(list, input2, 0, list.size()-1);
            trial.endTimeTrial(i);
        }
        double recursiveAverage = trial.round(trial.average(),7);
        System.out.println("Average Recursive Search Time: "+recursiveAverage+" milliseconds");
        //Print explaination why iterave is faster
        System.out.println("The Iterative search is usually faster than the recursive because it is simpler and doesn't add to the stack");
    }
    //Generates an ordered array list of a certain length
    public static ArrayList<Integer> generateOrderedArrayList(int input) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        //Create ordered arraylist
        for(int i=1;i<=input;i++){
            list.add((int)(list.get(i-1)+Math.random()*5+1));
        }
        return list;
    }
    //Iterative Binary search algorithm
    public static int binarySearchIt(ArrayList<Integer> arr, int key){
        int low = 0;
        int high = arr.size() - 1;
        int mid = (low + high) / 2;
        while (low <= high){
            if (arr.get(mid) < key){
                low = mid + 1;
            }
            else if (arr.get(mid) == key){
                return mid;
            }
            else{
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return -1;
    }
    //Recursive binary search algorithm
    public static int binarySearchRec(ArrayList<Integer> arr, int key, int low, int high){
        if(high<low){
            return -1;
        }
        if (arr.get((low+high)/2) < key){
            low = (low+high)/2 + 1;
        }
        else if (arr.get((low+high)/2) == key){
            return (low+high)/2;
        }
        else{
            high = (low+high)/2 - 1;
        }
        return binarySearchRec(arr, key,low,high);
    }
}
