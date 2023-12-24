/*
Sam Sah-Nixon
Created: 11/14/22
Last Modified: 11/21/22
Project that checks if a inputed password is valid with certain criteria, 
create a random valid password 
and then cracks the password using a brute force method per character
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // Create important variables to be used throughout the program
        final String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+[{]}|;:'\",<.>/?`~\\";
        Validator validator = new Validator();
        Generator generator = new Generator(chars, 0);
        Cracker cracker = new Cracker(chars,"passwords.txt",10);
        Scanner scanner = new Scanner(System.in);
        String choice;
        boolean run=true;
        while(run){
            //Runs the interface in which you decide what you want to do with the program
            System.out.println("\nWhat would you like to do?");
            System.out.println("v/V: Validate a password, g/G: Generate a password, c/C: Crack a password, q/Q: Quit");
            choice = scanner.next();
            if(choice.equalsIgnoreCase("v")){
                //Tells you if an inputed password is valid
                System.out.println("Please enter a password to validate");
                validator.resetCounters(0);
                validator.setPassword(scanner.next());
                if(validator.isValid(0,true)){
                    System.out.println("Password is Valid!");
                }    
                else{
                    System.out.println("Password is not Valid!");
                }
            }
            else if(choice.equalsIgnoreCase("g")){
                //Generates a random valid password with an inputed length
                System.out.println("Enter length of generated password");
                choice = scanner.next();
                try{
                    //The length must be an integer between 6 and 20
                    if(Integer.parseInt(choice)<6 || Integer.parseInt(choice)>20){
                        System.out.println("Password must be between 6 and 20 characters!");
                    }
                    //If it is between 6 and 20 it will generate a password
                    else{
                        generator.setLength(Integer.parseInt(choice));
                        generator.setPassword("");
                        System.out.println("Password Generated!: "+generator.generatePassword());
                    }
                //If you dont input an integer this error will run instead
                } catch(Exception e){
                    System.out.println("Please enter a number!");
                }
            }
            else if(choice.equalsIgnoreCase("c")){
                //Cracks a password using 2 different input methods. You can input your own or use a generator
                System.out.println("Press 1 to input your own password.\nPress 2 to use a generated password.");
                choice=scanner.next();
                if(choice.equals("1")){
                    //Cracks a password using an inputed password from length 6 to 20
                    System.out.println("Enter password to crack");
                    choice = scanner.next();
                    if(choice.length()<6 || choice.length()>20){
                        System.out.println("Password must be between 6 and 20 characters!");
                    }
                    else{
                        System.out.println("Cracking password...");
                        cracker = new Cracker(chars,"passwords.txt",10);
                        cracker.setPassword(choice);
                        System.out.println("Password Cracked!: "+cracker.crackPassword("",0, 0));
                    }
                    
                }
                else if(choice.equals("2")){
                    //Cracks a password using a generated password from length 6 to 20
                    System.out.println("Enter length of generated password");
                    choice=scanner.next();
                    try{
                        if(Integer.parseInt(choice)<6 || Integer.parseInt(choice)>20){
                            System.out.println("Password must be between 6 and 20 characters!");
                        }
                        else{
                            cracker = new Cracker(chars,"passwords.txt",10);
                            generator.setLength(Integer.parseInt(choice));
                            cracker.setPassword(generator.generatePassword());
                            System.out.println("Generated Password is "+cracker.getPassword()+"\nCracking password...");
                            System.out.println("Password Cracked!: "+cracker.crackPassword("",0, 0));
                        }
                    //If the inputed length isnt an integer this will run instead
                    } catch(Exception e){
                        System.out.println("Please enter a number!");
                    }
                }
                //If you input something other than 1 or 2 this will run instead
                else{
                    System.out.println("Invalid input!");
                }
            }
            else if(choice.equalsIgnoreCase("q")){
                //This will end the program
                System.out.println("Quitting...");
                run=false;
            }
            //If you input something other than v/V, g/G, c/C, or q/Q this will run instead
            else{
                System.out.println("Invalid input! Try Again");
            }
        }
    }
}
