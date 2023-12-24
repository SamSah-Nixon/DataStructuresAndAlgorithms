/*
Sam Sah-Nixon
9/22/22
Makes an employee directory with information from an input file and outputs weekly salary in output file
*/
import java.io.*;
import java.util.*;

public class Files{
	public static void main(String[] args) {
		//Input neccesary varibales to read and write in the files 
		FileReader reader = null;
		Scanner inData = null;
		FileWriter writer = null;
		PrintWriter out = null;
		//Make an employeelist and employeeNumber to track which employee is being edited
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		int employeeNumber=0;
		//Open Input File at Input.txt
		try{
			reader = new FileReader("Input.txt");
			inData = new Scanner(reader);
		} catch(IOException e){
			System.out.println("Opening input file failed: "+e);	
			System.exit(0);
		}
		//Open Output File at Outpit.txt
		try{
			writer = new FileWriter("Output.txt",true);
			out = new PrintWriter(writer);
		} catch(IOException e){
			System.out.println("Opening output file failed: "+e);
			System.exit(0);
		}
		System.out.println("Files opened succesfully!");
		//Goes through the lines and splits each part on a line into a string of words
		while(inData.hasNextLine()){
			String line = inData.nextLine();
			line=line.trim();
			String[] words = line.split(";");
			//Add the employee to the list
			try{
			employeeList.add(new Employee(words));
			} catch(Exception e){
				System.out.println("Incorrect Documentation in Input: "+e);
				System.exit(0);
			}
			//print out the employees info
			out.println(" "+employeeList.get(employeeNumber).toString());
			employeeNumber++;
		}
		closeFiles(reader,writer);
		System.out.println("Files closed Succesfly!");
	}
	public static void closeFiles(FileReader reader, FileWriter writer){
		//closes files
		try {
			reader.close();
			writer.close();
		} catch(IOException e){
			System.out.println("Closing files failed: "+e);
			System.exit(0);
		}
	}
}