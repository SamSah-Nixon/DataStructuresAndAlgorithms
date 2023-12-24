/*
Sam Sah-Nixon
Created: 10/01/22
Last Modified: 10/04/22
Class for gradebook project
Stores a students name and grades. The position of the grade in the list corresponds to the list of assessments
*/
import java.util.*;
public class Student{
	private String first;
	private String last;
	private ArrayList<Integer> grades = new ArrayList<Integer>();
	public Student(String first,String last){
		this.first = first;
		this.last = last;
	}
	public String getName(){
		return first+" "+last;
	}
	public String getLastName(){
		return last;
	}
	public String getFirstName(){
		return first;
	}
	public ArrayList<Integer> getGrade(){
		return grades;
	}
	public void addGrade(int grade){
		grades.add(grade);
	}
	public void setGrades(ArrayList<Integer> grades){
		this.grades = grades;
	}
}