/*
Sam Sah-Nixon
Created: 9/26/22
Last Modified: 10/06/22
Program allows you to create and save a gradebook for tracking your assessments and your student's grades 
*/
import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args){
		//Declare variables to be used throughtout the code
		boolean exit = false;
		Scanner scanner = new Scanner(System.in);
		String input,className;
		Gradebook gradebook = new Gradebook();
		//Input neccesary varibales to read and write in the files 
		FileReader reader = null;
		Scanner inData = null;
		FileWriter writer = null;
		PrintWriter out = null;
		//Asks user to enter class name
		System.out.println("Enter Class Name");
		className = scanner.next();
		//Create file with name of the class you inputed
		File f = new File(className+".grade");
		try{
			f.createNewFile();
			reader = new FileReader(f);
			inData = new Scanner(reader);
		} catch(IOException e){
			System.out.println("Opening Gradebook failed: "+e);	
			System.exit(0);
		}
			//If code exists in the file load the information from the code into the gradebook.
			if(inData.hasNextLine()){ 
				loadGradebook(gradebook,inData);
			}
			//If the file is empty then prompt the user to setup a weighting system
			else{
				System.out.println("You have created a new class. ");
				gradebook.changeWeighting();
			}
		//Start regular program
		while(exit==false){
			System.out.println("\nWhat action would you like to do? \nTo add a new assessment, type 1. \nTo add a new student, type 2. \nTo edit a specific student's grade, type 3. \nTo delete an assessment, type 4. \nTo delete a student, type 5. \nTo make new assessment weighting, type 6.(This will delete all current assessments and grades!)\nTo calculate a students overall grade, type 7\nTo print the gradebook, type 8\nTo save program, type 9");
			input = scanner.next();
			//Add Assessment
			if(input.equals("1")){gradebook.addAssessment();}
			//Add student
			else if(input.equals("2")){gradebook.addStudent();}
			//Edit specific grade of specific student
			else if(input.equals("3")){	gradebook.editStudent();}
			//Delete assessment
			else if(input.equals("4")){gradebook.deleteAssessment();}
			//Delete student
			else if(input.equals("5")){gradebook.deleteStudent();}
			//Change the weighting of an assessment
			else if(input.equals("6")){gradebook.changeWeighting();}
			//Calculates the letter grade of a specific students
			else if(input.equals("7")){gradebook.calculateGrade();}
			//Prints the gradebook out
			else if(input.equals("8")){gradebook.printGradebook();}
			//Asks user if they want to quit program
			else if(input.equals("9")){exit=repeat(scanner);}
			else{
				System.out.println("\nYou did not input one of the avaiable options try again");
			}
			
		}
		//Closes the file and re makes to delete what was already in the file
		try{
			reader.close();
			f.delete();
			f = new File(className+".grade");
			writer = new FileWriter(f,true);
			out = new PrintWriter(writer);
		} catch(IOException e){
			System.out.println(":( Saving gradebook failed: "+e);
		}
		//Write down everything in the classes back into the new, empty file
		saveGradebook(gradebook, out);
		//Closes file writers
		try {
			writer.close();
		} catch(IOException e){
			System.out.println("Closing Gradebook failed: "+e);
			System.exit(0);
		}
	}
	public static boolean repeat(Scanner scanner){
		String answer="";
		//keep running this until the user intputs a Y or an N
		while(answer.equalsIgnoreCase("Y")==false && answer.equalsIgnoreCase("N")==false){
		System.out.println("Save and Exit Program? Y/N");
		answer = scanner.next();
		if(answer.equalsIgnoreCase("Y")){
			return true;
		}
		else if(answer.equalsIgnoreCase("N")==false){
			System.out.println("\nYou did not input Y/N. Try Again\n");
			}	
		}
		return false;
	}
	public static void loadGradebook(Gradebook gradebook, Scanner inData){
		String words[];
		int weight=0;
		try{
					//Writes down information on assessment weighting
					words = inData.nextLine().split(";");
					for(int i=0;i<words.length;i+=2){
						gradebook.addWeight(new Weight(words[i],Integer.parseInt(words[i+1])));
					}
					//Writes down information on assessments
					words = inData.nextLine().split(";");
					if(words.length>1){
						for(int i=0;i<words.length;i+=2){
							for(int j=0;j<gradebook.getWeights().size();j++){
								if(gradebook.getWeights().get(j).getType().equals(words[i+1])){
									weight = gradebook.getWeights().get(j).getWeight();
								}
							}
							gradebook.addAssessment(new Assessment(words[i],new Weight(words[i+1],weight)));
						}
					}
					//Writes down information on the students
					for(int i=0;inData.hasNextLine();i++){
						words = inData.nextLine().split(";");
						gradebook.addStudent(new Student(words[0],words[1]));
						//For loop goes through each grade of the student and adds it to the students list of grades
						for(int j=2;j<words.length;j++){
							gradebook.getStudents().get(i).addGrade(Integer.parseInt(words[j]));
						}
					}
				} catch(Exception e){
					System.out.println("Incorrect Documention in gradebook file: "+e);
					System.exit(0);
				}
	}
	public static void saveGradebook(Gradebook gradebook, PrintWriter out){
		//Takes info changed in the program and writes it down in the appropriate file
		for(int i=0;i<gradebook.getWeights().size();i++){
			out.print(gradebook.getWeights().get(i).getType()+";"+gradebook.getWeights().get(i).getWeight()+";");
		}
		out.println();
		for(int i=0;i<gradebook.getAssessments().size();i++){
			out.print(gradebook.getAssessments().get(i).getName()+";"+gradebook.getAssessments().get(i).getWeight().getType()+";");
		}
		out.println();
		for(int i=0;i<gradebook.getStudents().size();i++){
			out.print(gradebook.getStudents().get(i).getFirstName()+";"+gradebook.getStudents().get(i).getLastName()+";");
			for(int j=0;j<gradebook.getStudents().get(i).getGrade().size();j++){
				out.print(gradebook.getStudents().get(i).getGrade().get(j)+";");
			}
			out.println();
		}
		System.out.println("Gradebook Saved!");
	}
}