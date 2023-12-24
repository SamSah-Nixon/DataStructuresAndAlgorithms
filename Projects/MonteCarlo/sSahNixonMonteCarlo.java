import java.util.Scanner;
public class sSahNixonMonteCarlo{
	public static void main(String args[]){
		//Make variables to be used throught out the code
		Scanner input = new Scanner(System.in);
		String answer="Y";
		boolean loop=true;
		double x,y;
		double[] xcoords;
		double[] ycoords;
		int points,insideCircleCount;
		//The program will repeat unless the user says so
		while(answer.equalsIgnoreCase("Y")){
			answer="";
			points=0;
			insideCircleCount=0;
			//this while keeps running until user inputs positive integer
			while(points<=0){
				try{
					//Fetch point amount
					System.out.println("How many points do you want?");
					points = input.nextInt();
					//Checks to see if the integer is positive
					if(points<1){
						System.out.println("Not Positive Integer. Try Again");
					}
				}
				catch(Exception e){
					//If not an integer run this
					System.out.println("Not an Integer. Try Again");
					input = new Scanner(System.in);
				}
			}
			//Makes random points
			xcoords = new double[points];
			ycoords = new double[points];
			System.out.println(points+" points");
			for(int i=0;i<points;i++){
				//Make random coords
				x = Math.random()*2-1;
				y = Math.random()*2-1;
				xcoords[i]=x;
				ycoords[i]=x;
				//Prints point coordinates
				//System.out.println(i+1+": "+x+", "+y);
				//Calculate if point is inside circle
				if((Math.pow(x-1,2)+Math.pow(y-1,2)>=1)){
					insideCircleCount++;
				}
			}
			//Prints how many points are in the circle and the number it calculates
			System.out.println("There are "+insideCircleCount+" points in the circle");
			double pi = (double)(4*insideCircleCount)/(double)points;
			System.out.println(pi+"\u007E \u03c0");
			//Promts the user and asks if they want to continue?
			while(answer.equalsIgnoreCase("Y")==false && answer.equalsIgnoreCase("N")==false){
				System.out.println("Go again? Y/N");
				answer = input.next();
				//If the user inputs something that isnt Y or N than tell them that and ask again for an input
				if(answer.equalsIgnoreCase("Y")==false && answer.equalsIgnoreCase("N")==false){
					System.out.println("You did not input Y/N. Try Again");
					}
			}
		}
		//If N is inputed then end the program. If Y is inputed then run the outer while loop again
		System.out.println("Goodbye!");
	}
}