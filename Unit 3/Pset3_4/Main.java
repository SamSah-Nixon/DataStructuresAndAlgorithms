/*
Sam Sah-Nixon
Created: 12/05/22
Last Modified: 12/07/22
Calculates the different sizes and times for selection sort in ascending and descending order
*/
import java.util.ArrayList;
import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int input1=0,input2=0,input3=0;
		String input4="";
		//Asks the user for important numbers for the amount you want to calculate in the time trials
        //For default values shown in the assignment description, input 10, 1000, 10
		try{
		    System.out.println("Enter number of data points you want to put in");
		    input1 = scanner.nextInt();
		    System.out.println("Enter how much you want the data amount to increment between each set");
		    input2 = scanner.nextInt();
		    System.out.println("Enter how many times you want to calculate the time for one data amount and average");
		    input3 = scanner.nextInt();
			System.out.println("Enter whether you want to sort it in ascending(+) or descending order(-)\nInput ' + ' or ' - ' ");
			input4 = scanner.next();
			//If the user does not input an integer end the program
		} catch(Exception e){
			System.out.println("Please restart the program and enter a positive integer");
			System.exit(0);
		}
		//Checks if the fourth input is a + or -
		if((input4.equals("+")) || (input4.equals("-"))){
			runTrial(input1, input2, input3, input4);
		} else {
			//If the fourth input is not a + or - then ask the user to input a + or -
			System.out.println("Please restart the program and enter a + or - for the fourth input");
		}
	}
	public static void runTrial(int input1,int input2, int input3, String input4){
		TimeTrial trial = new TimeTrial(input3);
		ArrayList<Integer> randArray;
		//Goes through the for loop for the number of data sets that you want to time
		for(int i=0;i<input1;i++){
			//Goes through the number of times you want to run a trial for one data amount
			for(int j=0;j<input3;j++){
				//Makes random array
				randArray = makeRandomArray((i+1)*input2);
				//Records start time
				trial.setStartRunTime(System.nanoTime());
				//Sort the array
				selectionSort(randArray,input4);
				//Records end time
				trial.endTimeTrial(j);
			}
			//Prints time
			System.out.println("size: "+(i+1)*input2+" time: average "+trial.round(trial.average(), 7)+" milliseconds");
		}
	}
	//Selection sort algorithm
    public static ArrayList<Integer> selectionSort(ArrayList<Integer> arr, String order){
        int minOrMaxIndex, temp;
		if(order.equals("+")){
			//Goes through all the elements in the array. 
        	//Each loop finds the smallest element in the array and puts it in the correct place
        	for (int i = 0; i < arr.size() - 1; i++) {
            	minOrMaxIndex = i;
            	//Goes through all elements and finds the smallest to put into the array
            	for (int j = i + 1; j < arr.size(); j++) {
             		if (arr.get(j) < arr.get(minOrMaxIndex)) {
                    	minOrMaxIndex = j;
                	}
            	}
            	temp = arr.get(i);
            	arr.set(i, arr.get(minOrMaxIndex));
            	arr.set(minOrMaxIndex,temp);
        	}
        	return arr;
		}
		else{
			//The same program except it selects the largest element first
        	for (int i = 0; i < arr.size() - 1; i++) {
            	minOrMaxIndex = i;
            	for (int j = i + 1; j < arr.size(); j++) {
					//This is the only line that is different from the ascending order
             		if (arr.get(j) > arr.get(minOrMaxIndex)) {
                    	minOrMaxIndex = j;
                	}
            	}
            	temp = arr.get(i);
            	arr.set(i, arr.get(minOrMaxIndex));
            	arr.set(minOrMaxIndex,temp);
        	}
        	return arr;
		}
    }
    
	//Makes an array with random positive integers with the inputed length
	public static ArrayList<Integer> makeRandomArray(int length){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=0;i<length;i++){
			nums.add((int)(Math.random()*Integer.MAX_VALUE));
		}
		return nums;
	}
}