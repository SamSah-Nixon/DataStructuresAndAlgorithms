package Pset3_0;

/*
Sam Sah-Nixon
Created: 12/01/22
Last Modified: 12/01/22
Shows the average times between a binary and sequential search with inputed array length
*/
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //Asks the user the length of the array to search and the number to search for
        System.out.println("Enter the length of the array list you want to search in");
        int input=0,input2=0;
        //Try catch to make sure the user inputs an integer
        try{
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
    //Runs 1000 trials of each search and returns the average time in milliseconds
    public static void searchTest(int input, int input2){
        ArrayList<Integer> list = new ArrayList<Integer>();
        //Create ordered arraylist
        for(int i=1;i<=input;i++){
            list.add(i);
        }
        //Run the binary search trials and return the average time
        TimeTrial trial = new TimeTrial(1000);
        for(int i=0;i<1000;i++){
            trial.setStartRunTime(System.nanoTime());
            binarySearch(list, input2);
            trial.endTimeTrial(i);
        }
        System.out.println("Average Bin Search Time: "+trial.round(trial.average(),7)+" milliseconds");
        //Run the sequential search trials and return the average time
        trial = new TimeTrial(1000);
        for(int i=0;i<1000;i++){
            trial.setStartRunTime(System.nanoTime());
            orderedSequentialSearch(list, input2);
            trial.endTimeTrial(i);
        }
        System.out.println("Average Seq Search Time: "+trial.round(trial.average(),7)+" milliseconds");
    }
    // Sequintial Search of an Integer ArrayList
    public static boolean orderedSequentialSearch(ArrayList<Integer> aList, int item){
        //Goes through the list systematically to check if the item is in the list
        for(int i=0;i<aList.size();i++){
            if(aList.get(i)==item){
                return true;
            }
        }
        return false;
    }
    //Binary Search of an Integer ArrayList
    public static boolean binarySearch(ArrayList<Integer> aList, int item){
        int low=0;
        int high=aList.size()-1;
        int mid=(low+high)/2;
        //Becuase the list is ordered the binary search halves the possible area 
        //for the item that is being searched for every time the loop runs
        while(low<=high){
            mid=(low+high)/2;
            if(aList.get(mid)==item){
                return true;
            }
            else if(aList.get(mid)>item){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
}

