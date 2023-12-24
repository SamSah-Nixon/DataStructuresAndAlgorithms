import java.util.*;
public class Employee{
	String id, name;
	double hourlyPay;
	ArrayList<Double> days = new ArrayList<Double>();
	public Employee(String[] words){
		id = words[0];
		name = words[1];
		hourlyPay = Double.parseDouble(words[2]);
		for(int i=3;i<words.length;i++){
			days.add(Double.parseDouble(words[i]));
		}
	}
	//function that calculates and round weekly pay to the nearest cent
	public double getWeeklyPay(){
		double pay=0;
		for(int i=0;i<days.size();i++){
			pay+=days.get(i);
		}
		pay*=hourlyPay;
		System.out.println(pay);
		pay = Math.round(pay * 100.0) / 100.0;
		System.out.println(pay);
		return pay;
	}
	//Getter and setters
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public double getHourlyPay(){
		return hourlyPay;
	}
	public void setId(String id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setHourlyPay(double hourlyPay){
		this.hourlyPay = hourlyPay;
	}
	//Prints string for output file
	public String toString(){
		String string="";
		string=id+";"+name+"; "+getWeeklyPay()+";";
		return string;
	}
}