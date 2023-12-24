/*
Sam Sah-Nixon
Created: 10/21/22
Last Modified: 12/15/22
Runs and calculates the average of multiple time trials
*/
public class TimeTrial{
	long[] runtimes;
	long startRunTime;
	public TimeTrial(int length){
		runtimes = new long[length];
	}
	//Inputs the time of the trial into the array
	public void endTimeTrial(int number){
		runtimes[number]=time(startRunTime,System.nanoTime());
	}
	//Finds the difference between the start and end of the time
	public long time(long startRunTime,long endRunTime){
		return endRunTime-startRunTime;
	}
	//Finds the average millisecond length in the array
	public double average(){
		long average=0;
		for(int i=0;i<runtimes.length;i++){
			average+=runtimes[i];
		}
		return ((double)average/(double)runtimes.length)/1000000.0;
	}
	//Rounds a double to a certain number of decimal places
	public static double round(double number, int places){
		return Math.round(number*Math.pow(10,places))/Math.pow(10,places);
	}
	//Getters and setters
	public void setStartRunTime(long startRunTime){
		this.startRunTime=startRunTime;
	}
	public void setruntime(int index,long runtime){
		runtimes[index]=runtime;
	}
	public long[] getRuntimes(){
		return runtimes;
	}
	public int getLength(){
		return runtimes.length;
	}
	public long getStartRunTime(){
		return startRunTime;
	}
}