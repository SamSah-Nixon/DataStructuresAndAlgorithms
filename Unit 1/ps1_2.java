/*
Sam Sah-Nixon
Created: 10/25/22
Last Modified: 10/26/22
Has a function that calculates the kth smallest number in a randomly sorted list in O(nLog(n))
*/
import java.util.Scanner;
public class ps1_2{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int input=0,input2=0;
		//Asks the user for input of important numbers in the function
		try{
		System.out.println("What length do you want the random array?");
		input = scanner.nextInt();
		System.out.println("What smallest number do you want to find?");
		input2 = scanner.nextInt();
		//If the numbers are not numbers or above zero then exit the program because the numbers will not be valid for the function
		} catch(Exception e){
			System.out.println("Please restart the program and enter an integer");
			System.exit(0);
		}
		if(input<1 || input2<1 || input<input2){
			System.out.println("Please restart the program and enter a valid length");
			System.exit(0);
		}
		//Prints the answer to the function
		System.out.println("The "+input2+placement(input2)+" smallest number in the list is "+findK(makeRandomArray(input),input2));
	}
	//The main function that does a merge sort which organizes numbers from smallest to greatest and returns the kth smallest number
	public static int findK(int[] a,int b){
		 a=mergeSort(a,0,a.length-1);
		 return a[b-1];
	}
	//Splits the array into 2 and uses recursion to continuously split until you cant any more and then merges the arrays
	public static int[] mergeSort(int[] a,int start,int end){
		//If the size of the array is only 1 then the end wont be greater than the start so it will return the original array
		if(end>start){
			mergeSort(a,start,(start+end)/2);
			mergeSort(a,(start+end)/2+1,end);
			merge(a,start,(start+end)/2,end);
		}
		return a; 
	}
	//Takes two parts of an array, splits it apart and sorts it from smallest to largest
	public static int[] merge(int[] a,int start, int mid, int end){
		int[] array1 = new int[mid-start+1];
		int[] array2 = new int[end-mid];
		//Copies values from the big array into the 2 smalle ones
		for(int i=0;i<array1.length;i++){
			array1[i]=a[start+i];
		}
		for(int i=0;i<array2.length;i++){
			array2[i]=a[mid+1+i];
		}
		int index1=0;
		int index2=0;
		int index3=start;
		//Goes through both arrays and copies the smallest numbers into the big array
		while(index1<array1.length && index2<array2.length){
			if(array1[index1]<array2[index2]){
				a[index3]=array1[index1];
				index1++;
			}
			else{
				a[index3]=array2[index2];
				index2++;
			}
			index3++;
		}
		//If there are numbers left over in the first array then add those onto the end
		while (index1 < array1.length) {
            a[index3] = array1[index1];
            index1++;
            index3++;
        }
        //If there are numbers left over in the second array then add those onto the end
        while (index2 < array2.length) {
            a[index3] = array2[index2];
            index2++;
            index3++;
        }
        return a;
	}
	//Makes an array with random positive integers with the inputed length
	public static int[] makeRandomArray(int length){
		int[] nums = new int[length];
		//Goes through every spot in the array and signs a random number between 0 and integer limit
		for(int i=0;i<nums.length;i++){
			nums[i]=(int)(Math.random()*Integer.MAX_VALUE);
		}
		return nums;
	}
	//I wanted a way to print the number placement ending onto the ends of the numbers. This function returns the correct ending with the number it is suffixing as input
	public static String placement(int place){
		if(place==1){
			return "st";
		}
		else if(place==2){
			return "nd";
		}
		else if(place==3){
			return "rd";
		}
		return "th";
	}
}