/*
Sam Sah-Nixon
Created: 11/2/22
Last Modified: 11/3/22
Contains the problem sets for unit 2 with explanations of each function by the function
*/
public class ProblemSet2{
    public static void main(String[] args){
        //Variable setup for tests
        int f=5,x=556;
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        String string = "beautiful";
        //Test for 2_0
        System.out.println("The Factorial of "+f+" = "+ps2_0(f));
        //Test for 2_1
        //Prints original array
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.print(" reversed is ");
        arr = ps2_1(arr,new int[arr.length],0);
        //Prints reversed array
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        //Test for 2_2
        System.out.println("\n"+string+" reversed is "+ps2_2(string,new String(),0));
        //Test for 2_3
        if(ps2_3(string,0,0,0)){
            System.out.println(string+" has more vowels than consonants");
        }
        else{
            System.out.println(string+" does not have more vowels than consonants");
        }
        //Test for 2_4
        System.out.println("the binary of "+x+" = "+ps2_4(x, "", 0));
    }
    //Calculates the factorial of input f
    public static int ps2_0(int f){
        //if f is negative return -1 because you can't have factorial a negative number
        if(f<0){
            return -1;
        }
        //when f is 0 return 1 so it stops recursing
        if(f<1){
            return 1;
        }
        //Multiply f by the previous number recursively
        return f*ps2_0(f-1);
    }
    //Takes in an array and returns the array reversed. result should start empty with the size of arr and index should start at 0
    public static int[] ps2_1(int[] arr, int[] result,int index){
        //When the index reaches the end of the array return the result array
        if(index==arr.length){
            return result;
        }
        //Find the reversed number for the current index and put it in the result array
        result[index] = arr[arr.length-index-1];
        //Move onto the next index
        return ps2_1(arr, result, index+1);
    }
    //Takes in an input string and outputs the string reversed
    //result starts empty and index should start at 0
    public static String ps2_2(String arr, String result,int index){
        //When the end of the string is reached return the string
        if(index==arr.length()){
            return result;
        }
        //Find the reversed character for the current index and put it in the result string
        result+=arr.charAt(arr.length()-index-1);
        //Move onto the next character in the string
        return ps2_2(arr, result, index+1);
    }
    //Tests to see if an inputed string s has more vowels than consonants
    //index,v and c should start at 0 when calling the function
    public static boolean ps2_3(String s,int index,int v,int c){
        //After checking through the entire string see which of more characters there are
        if(index==s.length()){
            return v>c;
        }
        //If the current character index is a vowel and one to the vowel count
        if(s.charAt(index)=='a' || s.charAt(index)=='e' || s.charAt(index)==('i') || s.charAt(index)=='o' || s.charAt(index)=='u'){
            v++;
        }
        //else add to the consonant count
        else{
            c++;
        }
        //Move onto the next character in the string
        return ps2_3(s, index+1, v, c);
    }
    //Turns a base 10 integer into a base 2 string. There will always be at least 8 characters in the string
    //b and index should start as empty and 0 respectively when calling the function
    public static String ps2_4(int x,String b,int index){
        //If the starting string is empty then calculate how many digits long the string will be
        if(b.equals("")){
            //Takes the rounded up number of log base2 of x to find how long the binary string will be
            index=(int)Math.ceil(Math.log10(x)/Math.log10(2));
            //If the string is less than 8 then make the length 8 because it should be at least 8 characters
            if(index<8){
                index=8;
            }
        }
        //If the index reaches the end of the string end the function and return the string
        if(index<1){
            return b;
            
        }
        //If a certain power can be taken away from x in that spot without x being 0 than take it away and put a 1 for that spot in the array
        if(Math.pow(2,index-1)<=x){
            b+="1";
            x-=Math.pow(2, index-1);
        }        
        //If it isn't than put a 0 in that place
        else{
            b+="0";
        }
        //Move onto the next digit in the binary string
        return ps2_4(x, b, index-1);
    }
    
}
