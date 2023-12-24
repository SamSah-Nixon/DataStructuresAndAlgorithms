/*
Sam Sah-Nixon
Created: 11/14/22
Last Modified: 11/20/22
Part of SafeCracker Project
Class to check if a password is valid 
and also create a random valid password
*/
public class Validator {
    int[] count;
    private String password;
    public Validator() {
        count=new int[4];
        password="";
    }
    // Method to check if a created string is a valid password recursively
    // Goes through the password and stores information on different the types of characters
    public boolean isValid(int index,boolean print){
        if(index == password.length()){
            //it will check to see if the password contains all the criteria it looked at
            if(password.length()<6 || password.length()>20){
                if(print){
                    System.out.println("Password must be between 6 and 20 characters");
                }
                return false;
            }
            if(count[0]<2){
                if(print){
                    System.out.println("Password must contain at least two uppercase letters");
                }
                return false;
            }
            if(count[1]<1){
                if(print){
                    System.out.println("Password must contain at least one lowercase letter");
                }
                return false;
            }
            if(count[2]<2){
                if(print){
                    System.out.println("Password must contain at least two digits");
                }
                return false;
            }
            if(count[3]<1){
                if(print){
                    System.out.println("Password must contain at least one special character");
                }
                return false;
            }
            return true;
        }
        //When recursing through each character of the array it will take note of what kind of character it is
        if(Character.isUpperCase(password.charAt(index))){
            count[0]++;
        }
        else if(Character.isLowerCase(password.charAt(index))){
            count[1]++;
        }
        else if(Character.isDigit(password.charAt(index))){
            count[2]++;
        }
        else if(("[{!@#$%^&*()<>?:.}]);\"").contains(password.charAt(index)+"")){
            count[3]++;
        }
        //Does this check before the end of searching through the whole password because it needs to look through the entire array individually anyways
        if(index>=2 && password.charAt(index) == password.charAt(index-1) && password.charAt(index) == (password.charAt(index-2))){ 
            if(print){
                System.out.println("Password cannot contain more than two of the same character in a row");
            }
            return false;
        }
        return isValid(index+1,print);
    }

    //Reset count recursively
    public void resetCounters(int index){
        if(index==count.length){
            //After resetting all the counters end the function
            return;
        }
        //Goes through all the counters and sets them to 0 recursively
        count[index]=0;
        index++;
        resetCounters(index);
    }
    //Getters and settters
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
