//File: ParkingTicket
//Description: The parking ticket program finds how long each car has been parked in the parking lot, and calculates 
//the total parking fee based on the given parking rate.
//
//ID: 6588108
//Name: ARUS THIENMEE
//Section: 3
//Grader: Anyamanee
//
//On my honor, ARUS THIENMEE, this lab assignment is my own work
//and I have not provided this code to any other students.
import java.util.Scanner;

public class ParkingTicket {
	public static int dHr, dMin, price;
	public static void printParkingDuration(String enter, String leave) {
		//get data
		
	
				int a = Integer.parseInt(enter);
				
				int b = Integer.parseInt(leave);
				
				
				int hrEnter = a/100; 
				int hrLeave = b/100;
				int minEnter = a%100;
				int minLeave = b%100;
				
				dHr = hrLeave - hrEnter;
				dMin = minLeave - minEnter;
				
				if(dMin >= 60) {
					dMin -= 60;
					dHr++;
				}
				if(dMin< 0) {
					dMin += 60;
					dHr--;
				}
				if(a > b){
					
					dHr+=24;
				}
				System.out.println("Entering time -> " + a);
				System.out.print("Leaving time -> " + b);
				if(a > b){
					System.out.println(" (overnight)");
				}
				System.out.println("Parking duration: " + dHr + " hours and " + dMin + " minutes");
				
	}

	public static void printVisual() {
		
		int dMinX = dMin +(dHr*60);
		for(int i = 0, hrc = 1; i < dMinX; i++) {
			
			if(i != 0 && i%60 == 0) {
				System.out.print( " " + hrc + "hr\n");
				hrc++;
			}
			if(i%15 == 0) {
				System.out.print('|');
			}
			System.out.print('*');
		}
		if (dMin != 0) {
			System.out.println(" \t| " + dMin + "min");
		}
		else {
			System.out.println();
		}
	}


	public static void printParkingFee(int hour, int minute) {
		
		int calHr = hour;
		price = 0;
		
		//round up min to hour
		if(minute != 0) {
			calHr++;
			}
		
		
		
	
		//first 2 hrs charge
		if(calHr <= 2 && calHr != 0) {
			price+= (calHr*10);
		}
		else {
			price+= 10;
		}
		calHr-=2;
		price += (calHr*40);
		System.out.println("Parking fee: " + price + " baht");
	}
	
	public static void main(String[]args) {
		//get data
		
		Scanner time = new Scanner(System.in);
		
		System.out.print("Entering time -> ");
		String a = time.nextLine();
		System.out.println(a);
		System.out.print("Leaving time -> ");
		String b = time.nextLine();
		System.out.println(b);
		
		
		
		//Print out duration
		printParkingDuration(a, b);
		
		//Print visual
		printVisual();
		
		//calculate price
		printParkingFee(dHr, dMin);
		
		
		
		
	time.close();	
	}
}

