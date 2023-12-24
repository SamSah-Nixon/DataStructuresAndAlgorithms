/*
Sam Sah-Nixon
Created: 10/25/22
Last Modified: 10/25/22
Has a findMin function with a time complexity of O(N) and tracks the runtime
To get the output listed as the example the number of data points is 10 and the increment amount is 1000
*/
import java.util.Scanner;
public class ps1_1{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int input1=0,input2=0,input3=0;
		int[] randArray;
		//Asks the user for important numbers for the amount you want to calculate in the time trials
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
				trial.setStartRunTime(System.currentTimeMillis());
				//Finds the minimum number in the array
				findMin(randArray);
				//Records end time
				trial.endTimeTrial(j);
			}
			//Prints time
			System.out.println("size: "+(i+1)*input2+" time: average "+trial.average()+" milliseconds");
		}
	}
	//Finds smallest number in an array
	public static int findMin(int[] nums){
		int min = Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++){
			if(nums[i]<min){
				min=nums[i];
			}
		}
		return min;
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