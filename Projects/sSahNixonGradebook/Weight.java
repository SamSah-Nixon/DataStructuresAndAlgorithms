/*
Sam Sah-Nixon
Created: 10/01/22
Last Modified: 10/05/22
Class for gradebook project
Stores the information of the different types of assessments and how much they are worth
*/
public class Weight{
	private int weight;
	private String type;
	public Weight(String type,int weight){
		this.type=type;
		this.weight=weight;
	}
	public String getType(){
		return type;
	}
	public int getWeight(){
		return weight;
	}
}