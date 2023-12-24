/*
Sam Sah-Nixon
Created: 11/14/22
Last Modified: 11/19/22
Part of SafeCracker Project
Generates a random valid password recursively
*/
public class Generator {
    private String password;
    private final String chars;
    private int index;
    private Validator validator;
    private int length;
    public Generator(String chars, int length) {
        this.chars=chars;
        password="";
        index=0;
        validator=new Validator();
        this.length = length;
    }
    // Method to create a random valid password
    public String generatePassword(){
        //Creates a random character and adds it to the password
        password += chars.charAt((int)(Math.random()*chars.length()))+"";
        if(index==length-1){
            //Checks if the randomly created password is valid
            index=0;
            validator.setPassword(password);
            validator.resetCounters(index);
            if(validator.isValid(0,false)){
                return validator.getPassword();
            }
            //If it is not valid it will reset the password and try again
            else{
                password="";
                return generatePassword();
            }
        }
        //Recusively calls itself until the string is as long as the password
        index++;
        return generatePassword();
    }
    //Getters and Setters
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
}
