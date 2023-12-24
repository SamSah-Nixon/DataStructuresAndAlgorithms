import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
 * Sam S-N
 * Date Created: 02/08/2023
 * Last Modified: 02/08/2023
 * Description: Time Trial for Radix Sort
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
		int input1=0,input2=0,input3=0;
		ArrayList<Integer> randArray;
		//Asks the user for important numbers for the amount you want to calculate in the time trials
        //For default values shown in the assignment description, input 10, 100, 10
		try{
		    System.out.println("Enter number of data points you want to put in");
		    input1 = scanner.nextInt();
		    System.out.println("Enter how much you want the data amount to increment between each set");
		    input2 = scanner.nextInt();
		    System.out.println("Enter how many times you want to calculate the time for one data amount and average");
		    input3 = scanner.nextInt();
		//If the user does not input an integer end the program
		} catch(Exception e){
			System.out.println("Please restart the program and enter a positive integer");
			System.exit(0);
		}
		TimeTrial trial = new TimeTrial(input3);
		//Goes through the for loop for the number of data sets that you want to time
		for(int i=0;i<input1;i++){
			//Goes through the number of times you want to run a trial for one data amount
			for(int j=0;j<input3;j++){
				//Makes random array
				randArray = makeArray((i+1)*1000);
				//Records start time
				trial.setStartRunTime(System.nanoTime());
				//Sort the array
				radixSort(randArray);
				//Records end time
				trial.endTimeTrial(j);
			}
			//Prints time
			System.out.println("size: "+(i+1)*input2+" time: average "+TimeTrial.round(trial.average(), 7)+" milliseconds");
		}
        scanner.close();
    }
    //Makes an array of random numbers
    public static ArrayList<Integer> makeArray(int size){
        ArrayList<Integer> randArray = new ArrayList<Integer>();
        for(int i=0;i<size;i++)
            randArray.add((int)(Math.random()*size));
        return randArray;
    }

    //Sorts an array using radix sort
    public static ArrayList<Integer> radixSort(ArrayList<Integer> arr) {
        //Calculate the number of digits in the largest number
        int max = (int) Math.log10(Collections.max(arr)) + 1;

        //For every digit in the number
        for (int i = 0; i < max; i++) {
            //Declare and Initialize a bucket for each digit
            ListQueue<Integer>[] buckets = new ListQueue[10];
            for (int j = 0; j < 10; j++)
                buckets[j] = new ListQueue<Integer>();

            //Put the numbers in the correct bucket
            for (int a : arr) {
                buckets[(int)(a / Math.pow(10, i)) % 10].enQueue(a);
            }

            //Put the numbers back into the array
            arr = new ArrayList<Integer>();
            for (ListQueue<Integer> queue : buckets) {
                while (!queue.isEmpty()) {
                    arr.add(queue.deQueue());
                }
            }
        }
        return arr;
    }
}
