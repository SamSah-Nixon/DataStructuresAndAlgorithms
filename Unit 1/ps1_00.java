/*
Sam Sah-Nixon
Created: 10/17/22
Last Modified: 10/17/22
Program to calculate the fibonacci sequence to the desired length that you want 
*/
import java.util.Scanner;
public class ps1_00{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		//Asks to input length of sequence
		System.out.println("Enter Length of Fibonacci Sequence");
		int[] sequence = sequence(scanner.nextInt());
		//Prints the sequence
		System.out.print("[");
		System.out.print(sequence[0]);
		for(int i=1;i<sequence.length;i++){
			System.out.print(", ");
		}
		System.out.print("]");
	}
	//Calculates the sequence - with the first 2 numbers being 0 and 1 the program takes the 2 previous numbers and the sum make the next number in the list
	public static int[] sequence(int input){
		int[] result = new int[input];
		if(result.length<1){
			return result;
		}
		result[0]=0;
		if(result.length<2){
			return result;
		}
		result[1]=1;
			for(int i=2;i<result.length;i++){
				result[i]=result[i-1]+result[i-2];
			}
		return result;
	}
}