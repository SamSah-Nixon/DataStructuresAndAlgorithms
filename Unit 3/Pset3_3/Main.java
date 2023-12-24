/*
Sam Sah-Nixon
Created: 12/05/22
Last Modified: 12/05/22
Calculates the different sizes and times of a bubble sort
*/
import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int input1=0,input2=0,input3=0;
		int[] randArray;
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
				randArray = makeRandomArray((i+1)*input2);
				//Records start time
				trial.setStartRunTime(System.nanoTime());
				//Sort the array
				selectionSort(randArray);
				//Records end time
				trial.endTimeTrial(j);
			}
			//Prints time
			System.out.println("size: "+(i+1)*input2+" time: average "+trial.round(trial.average(), 7)+" milliseconds");
		}
	}
	//Selection sort algorithm
    public static int[] selectionSort(int[] arr){
        int minIndex, temp;
        //Goes through all the elements in the array. 
        //Each loop finds the smallest element in the array and puts it in the correct place
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            //Goes through all elements and finds the smallest to put into the array
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }
    
	//Makes an array with random positive integers with the inputed length
	public static int[] makeRandomArray(int length){
		int[] nums = new int[length];
		for(int i=0;i<nums.length;i++){
			nums[i]=(int)(Math.random()*Integer.MAX_VALUE);
		}
		return nums;
	}
}