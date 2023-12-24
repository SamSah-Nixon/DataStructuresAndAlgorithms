/*
Sam Sah-Nixon
Created: 10/01/22
Last Modified: 10/06/22
Class for Gradebook project
Stores an assessment name and type of assessment
*/
public class Assessment{
	private Weight type;
	private String name;
	public Assessment(String name,Weight type){
		this.type = type;
		this.name = name;
	}
	public Weight getWeight(){
		return type;
	}
	public String getName(){
		return name;
	}
}