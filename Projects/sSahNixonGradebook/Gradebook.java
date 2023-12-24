/*
Sam Sah-Nixon
Created: 10/3/22
Last Modified: 10/06/22
Class for gradebook project
Gradebook class for storing all the information about the assessments, grades and students
*/
import java.util.*;
import java.io.*;
public class Gradebook{
	private ArrayList<Weight> weights = new ArrayList<Weight>();
	private ArrayList<Assessment> assessments = new ArrayList<Assessment>();
	private ArrayList<Student> students = new ArrayList<Student>();
	Scanner scanner = new Scanner(System.in);
	String input,input2;
	boolean complete,complete2;
	public Gradebook(){
	}
	public ArrayList<Weight> getWeights(){
		return weights;
	}
	public ArrayList<Assessment> getAssessments(){
		return assessments;
	}
	public ArrayList<Student> getStudents(){
		return students;
	}
	public void setWeights(ArrayList<Weight> weights){
		this.weights=weights;
	}
	public void setAssessments(ArrayList<Assessment> assessments){
		this.assessments=assessments;
	}
	public void setStudents(ArrayList<Student> students){
		this.students=students;
	}
	public void addWeight(Weight weight){
		weights.add(weight);
	}
	public void addAssessment(Assessment assessment){
		assessments.add(assessment);
	}
	public void addStudent(Student student){
		students.add(student);
	}
	public void addAssessment(){
		complete = true;
		boolean complete2 = true;
		boolean duplicate = false;
		System.out.println("Enter Assessment Name (No Spaces)");
		input = scanner.next();
		//If the assessment name already exists dont add it
		for(int i=0;i<assessments.size();i++){
			if(assessments.get(i).getName().equalsIgnoreCase(input)){
				complete=false;
				duplicate=true;
			}
		}
		while(complete){
			System.out.println("Enter Type of Assessment");
			//Prints different types of assessment here for reference to the user
			for(int i=0;i<getWeights().size();i++){
				System.out.println(weights.get(i).getType()+", ");
			}
			input2 = scanner.next();
			for(int j=0;j<weights.size();j++){
				//If the input matches an already existing weight type then it will add the assessment
				if(input2.equalsIgnoreCase(weights.get(j).getType())==true){
					complete=false;
					addAssessment(new Assessment(input,new Weight(input2,weights.get(j).getWeight())));
					//Next it will prompt the user to input the grade of the assessment for every student
					for(int i=0;i<students.size();i++){
						complete2=true;
						while(complete2){
							System.out.println("Enter Percent grade for "+students.get(i).getName());
							input = scanner.next();
							try{
								students.get(i).addGrade(Integer.parseInt(input));
								complete2=false;
							//If dont enter a number it will ask you to re enter an integer 
							} catch(Exception e){
								System.out.println("\n!Please enter an integer for grade!");
								scanner = new Scanner(System.in);
								complete2=true;
							}
						}
					}
				}
			}
			if(complete==true){
				System.out.println("\nPlease input one the listed assessment types");
			}
		}
		if(duplicate){
			System.out.println("\nYou already created an assessment with this name");
		}
		else{
		System.out.println("\nAssessment Created!");
		}
	}
	public void addStudent(){
		boolean duplicate=false;
		complete=false;
		System.out.println("Enter Student's First Name(No spaces!)");
		input = scanner.next();
		System.out.println("Enter Student's Last Name(No spaces!)");
		input2 = scanner.next();
		//Checks to see if the student already exists
		for(int i=0;i<students.size();i++){
			if(students.get(i).getFirstName().equalsIgnoreCase(input)&&students.get(i).getLastName().equalsIgnoreCase(input2)){
				duplicate=true;
			}
		}
		//If doesnt already exists add the student
		if(duplicate==false){
			addStudent(new Student(input,input2));
			if(assessments.size()<1){
				complete=true;
			}
			//Goes throught all assessments and asks for grades of each of them for the student added
			for(int i=0;i<assessments.size();i++){
				complete=false;
				while(complete==false){
					System.out.println("Enter Percent Grade for "+assessments.get(i).getName());
					try{
						input = scanner.next();
						students.get(students.size()-1).addGrade(Integer.parseInt(input));
						complete=true;
					} catch(Exception e){
						System.out.println("\nPlease enter an integer");
						input = "";
					}
				}
			}
		}
		if(complete){
			System.out.println("\nStudent Created!");
		}
		else{
			System.out.println("\nYou already created this student!");
		}
	}
	public void editStudent(){
		complete = false;
		complete2 = false;
		System.out.println("Enter Student's First Name");
		input = scanner.next();
		System.out.println("Enter Student's Last Name");
		input2 = scanner.next();
		//Goes through and checks if the student inputed exists
		for(int i=0;i<students.size();i++){
			if(students.get(i).getFirstName().equalsIgnoreCase(input) && students.get(i).getLastName().equalsIgnoreCase(input2)){
				complete = true;
				System.out.println("What Assessment would you like to edit?");
				//Lists every assessment for reference to input one to edit
				for(int j=0;j<assessments.size();j++){
					System.out.println(assessments.get(j).getName()+",");
				}
				input = scanner.next();
				//Goes through and checks if the inputed assessment existed
				for(int j=0;j<assessments.size();j++){
					if(input.equalsIgnoreCase(assessments.get(j).getName())){
						complete2 = true;
						System.out.println("What grade would you like to change it to?");
						input = scanner.next();
						students.get(i).getGrade().set(j,Integer.parseInt(input));
					}
				}
			}
		}
		//If it didnt find an assessment or student from input it will tell you what was missing
		if(complete&&complete2){
		System.out.println("\nGrade Edited!");
		}
		else if(complete){
			System.out.println("\nAssessment not found :(");
		}
		else{
			System.out.println("\nStudent not found :(");
		}
	}
	public void deleteAssessment(){
		complete = false;
		System.out.println("Please enter name of assessment");
		//Lists every assessment for reference to input one to edit
		for(int j=0;j<assessments.size();j++){
			System.out.println(assessments.get(j).getName()+",");
		}
		input = scanner.next();
		//Goes through all assessments to see if it exists
		for(int i=0;i<assessments.size();i++){
			if(assessments.get(i).getName().equalsIgnoreCase(input)){
				complete=true;
				assessments.remove(i);
				for(int j=0;j<students.size();j++){
					students.get(j).getGrade().remove(i);
				}
			}
		}
		if(complete){
		System.out.println("\nAssessment Deleted!");
		}
		else{
			System.out.println("\nAssessment not found :(");
		}
	}
	public void deleteStudent(){
		complete=false;
		System.out.println("Please enter first name of student");
		input = scanner.next();
		System.out.println("Please enter last name of student");
		input2 = scanner.next();
		//Goes through all students to see if the student exists
		for(int i=0;i<students.size();i++){
			if(students.get(i).getFirstName().equalsIgnoreCase(input)&&students.get(i).getLastName().equalsIgnoreCase(input2)){
				complete = true;
				students.remove(i);
			}
		}
		if(complete){
		System.out.println("\nStudent Deleted!");
		}
		else{
			System.out.println("\nStudent not found :(");
		}
	}
	public void changeWeighting(){
		int counter=0;
		weights = new ArrayList<Weight>();
		assessments = new ArrayList<Assessment>();
		//Resets all students grades and assessments
		for(int i=0;i<students.size();i++){
			students.get(i).setGrades(new ArrayList<Integer>());
		}
		//While the weight does add up to 100 keep asking to add new weights
		while(counter!=100){
			System.out.println("Please input a type of assessment weight. eg. Test,Quiz,Homework");
			input = scanner.next();
			System.out.println("What percent will this type of assessment be worth?");
			input2 = scanner.next();
			try{
				if((counter+Integer.parseInt(input2))>100){
					System.out.println("\n!You have gone over 100% weight. Try again!\n");
				}
				//If input is under 0 then tell them you have to enter a positive integer
				else if(Integer.parseInt(input2)<0){
					System.out.println("Try again !Please enter a positive integer!");
				}
				else{
					weights.add(new Weight(input,Integer.parseInt(input2)));
					counter+=Integer.parseInt(input2);
					System.out.println("Current weights add up to "+counter+"%");
				}
			} catch(Exception e){
						System.out.println("\nTry again !!!Please enter an integer for a weight!!!\n");
						input2 = "0";
			}
		}
		System.out.println("\nWeighting system created!");
	}
	public  void calculateGrade(){
		complete=false;
		int grade = 0;
		int weight = 0;
		System.out.println("Please enter first name of student(No Spaces)");
		input = scanner.next();
		System.out.println("Please enter last name of student(No Spaces)");
		input2 = scanner.next();
		//Looks and finds the student you inputed
		for(int i=0;i<students.size();i++){
			if(students.get(i).getFirstName().equalsIgnoreCase(input)&&students.get(i).getLastName().equalsIgnoreCase(input2)){
				complete=true;
				//Goes through every grade, weights it and adds it to the calculation
				for(int j=0;j<students.get(i).getGrade().size();j++){
					grade+=students.get(i).getGrade().get(j)*assessments.get(j).getWeight().getWeight()*0.01;
					weight+=assessments.get(j).getWeight().getWeight();
				}
				System.out.println("\n"+input+"'s overall grade is "+letterGrade((double)grade/((double)weight/100)));
			}
		}
		if(complete==false){
			System.out.println("\nStudent not found :(");
		}
	}
	public String letterGrade(double grade){
		//Calculates the letter grade with an inputed number grade
		if(grade<60){return "F";}
		else if(grade<63){return "D-";}
		else if(grade<67){return "D";}
		else if(grade<70){return "D+";}
		else if(grade<73){return "C-";}
		else if(grade<77){return "C";}
		else if(grade<80){return "C+";}
		else if(grade<83){return "B-";}
		else if(grade<87){return "B";}
		else if(grade<90){return "B+";}
		else if(grade<93){return "A-";}
		else if(grade<97){return "A";}
		else if(grade<=100){return "A+";}
		else{
			//If the grade is greater than 100 then return the number that was inputed
			return String.valueOf(grade);
		}
	}
	public void printGradebook(){
		//Prints grade book so you can see all listed weights, assessments and students
		System.out.println("\nWeighting System:");
		for(int i=0;i<weights.size();i++){
			System.out.println(weights.get(i).getType()+" is worth "+weights.get(i).getWeight()+"%");
		}
		System.out.println("Assesments:");
		for(int i=0;i<assessments.size();i++){
			System.out.println(assessments.get(i).getName()+" is a "+assessments.get(i).getWeight().getType()+" assessment");
			for(int j=0;j<students.size();j++){
				System.out.println(students.get(j).getName()+" has a "+students.get(j).getGrade().get(i));
			}
		}
		if(assessments.size()<1){
			System.out.println("None");
		}
	}
}