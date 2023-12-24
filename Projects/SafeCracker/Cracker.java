/*
Sam Sah-Nixon
Created: 11/14/22
Last Modified: 11/21/22
Part of SafeCracker Project
Class to crack the password using a brute force method per character 
and then write the guesses down in a text file
*/
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cracker {
    private String password;
    private String chars;
    private File file;
    private FileWriter fileWriter;
    private ArrayList<String> guesses;
    private int breakIndex;
    public Cracker(String chars, String filename,int breakIndex) {
        this.file = new File(filename);
        this.chars=chars;
        password = "";
        guesses = new ArrayList<String>();
        this.breakIndex=breakIndex;
        try {
            this.fileWriter = new FileWriter(file,true);
        } catch (IOException e) {
            System.out.println("Error opening file: "+e);
        }
    }
    // Method to crack the password using a brute force method per character
    public String crackPassword(String crackedPassword, int index,int passwordIndex){
        guesses.add(crackedPassword+chars.charAt(index));
        //Goes through every character to see if it is equal to the next one in the password
        if((chars.charAt(index)+"").equals(password.charAt(passwordIndex)+"")){
            //If it is go to the next character in the password and start again with the same method
            crackedPassword+=chars.charAt(index);
            index=-1;
            passwordIndex++;
            if(passwordIndex==password.length()){
                //Return the password after it is fully complete
                writePassword(0);
                return crackedPassword;
            }
        }
        //Goes recursevly through every index in the possible characters
        return crackPassword(crackedPassword,index+1,passwordIndex);
    }

    public void writePassword(int index){
        try{
            if(index==0){
                System.out.println("\nIt took "+guesses.size()+" guesses to crack the password "+password);
                fileWriter.write("\nIt took "+guesses.size()+" guesses to crack the password: "+password+"\n");
            }
            fileWriter.write(index+". "+guesses.get(index)+"; ");
            if(index%breakIndex==breakIndex-1){
                fileWriter.write("\n");
            }
            if(index==guesses.size()-1){  
                fileWriter.write("\n");  
                fileWriter.close();  
                return;
            }
            writePassword(index+1);
        } catch (IOException e) {
            System.out.println("Error writing to file : "+e);
        }
    }
    //Getters and Setters   
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
