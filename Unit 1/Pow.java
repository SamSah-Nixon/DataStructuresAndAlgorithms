/*
Sam Sah-Nixon
Created: 10/17/22
Last Modified: 10/17/22
Program for testing out different types of algorithm effeciency
*/
public class Pow{
	public static void main(String[] args){
		System.out.println(sumtoN(5));
	}
	public static int power(int num,int pow){
		int result=num;
		for(int i=1;i<pow;i++){
			result*=num;
		}
		return result;
	}

	// O(n)
	public static int sumtoN(int n){
		int result = 0;
		for(int i=0;i<=n;i++){
			result+=i;
		}
		return result;
	}
	// O(1)
	public static int sum(int n){
		return (n*(n+1))/2;
	}
}