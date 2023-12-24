/*
Sam Sah-Nixon
Created: 10/31/22
Last Modified: 11/2/22
Has some recursive functions that was non graded work
*/
public class Main{
    public static void main(String[] args){
    }
    //Find a value x in an array
    public static boolean findX(int[] arr,int x,int index){
        if(arr.length<1){
            return false;
        }
        else if(arr[index]==x){
            return true;
        }
        else if(index==arr.length-1){
            return false;
        }
        else{
            return findX(arr,x,index+1);
        }
    }
    //Find the sum of 2 numbers in an array using recursion
    public static int[] find2Sum(int[] a,int k,int index1,int index2){
        if(a[index1]+a[index2]==k && index1!=index2){
            int[] result = {a[index1],a[index2]};
            return result;
        }
        else if(index1==a.length-1){
            index1=index2;
            if(index2!=a.length-1){
                index2++;
            }
            else{
                return new int[0];
            }
        } 
        return find2Sum(a,k,index1+1,index2);
    }
    //Find x to the n'th power using traditional recursion
    public static int power(int x,int n){
        if(n==0){
            return 1;
        }
        else if(n==1){
            return x;
        }
        else{
            return x*power(x,n-1);
        }
    }
    //Find x to the n'th power using repeated squaring recursion
    public static int repeatedSquaringPower(int x,int n){
        if(n==0){
            return 1;
        }
        else if(n==1){
            return x;
        }
        else if(n%2==0){
            return repeatedSquaringPower(x*x,n/2);
        }
        else{
            return x*repeatedSquaringPower(x*x,(n-1)/2);
        }
    }
    /* recusion method to find max value in an array without max function*/
    public static int findMax(int[] arr,int index){
        if(index==arr.length-1){
            return arr[index];
        }
        else{
            int max = findMax(arr,index+1);
            if(arr[index]>max){
                return arr[index];
            }
            else{
                return max;
            }
        }
    }
}
