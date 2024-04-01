
// File: Myprogram.java
// Description: In this lab, you are about to implement a Java program to solve THREE small tasks when users select a task
//numbers 1, 2, or 3.
// Assignment Number: 1
//
// ID: 6588108
// Name: ARUS THIENMEE
// Section: 3
// Grader: Anyamanee
//
// On my honor, ARUS THIENMEE, this lab assignment is my own work
// and I have not provided this code to any other students.



import java.util.Scanner;
public class Myprogram {

	public static void main(String[]args) {

	
		Scanner in = new Scanner(System.in);
		boolean status = true;
		do{
			
			System.out.println("Please select number 1-3 to run the program, or press 0 to quit:");
			int number = in.nextInt();			
			
			if(number == 1) {
				System.out.println("Please insert number to the program and press 0 to to calculate the Max, Min, and Average value:");
				 
				//then the program should calculate and display the largest (Max), smallest (Min), and Average numbers entered.
				
				float n = in.nextFloat();
				float max = n, min = n;
				float x = 0, count =0;
				x += n;
				do{
					
				if(n > max) {
					max = n;
				}
				else if(n > min) {
					min = n;
				}
				n = in.nextInt();
				x += n;
				count++;
				}while(n != 0);
				
				System.out.printf("Max: %.0f\nMin: %.0f\nAverage: %.1f\n", max,min,x/count);
				
				
				
			}else if(number == 2) {
				System.out.println("Please insert any number as a high of the triangle:");
				int tri = in.nextInt();
					for(int i = 0, x = 1, s = tri; i < tri; i++,x+=2,s--) {
						for(int j = 0; j < s; j++) {
							System.out.print(" ");
						}
						for(int j = 1; j <= x; j++) {
							
							System.out.printf("%d", i);
							
						}
						System.out.println();
					}
					
			}else if(number ==3) {
				
				for(int i = 0; i < 7; i++) {
					
					System.out.print("  ");
					for(int j = 0; j< 13; j++) {
						
						if(i == 0 || i ==6) {
							if(j <= 2 || (j <=7 && j >=5) || (j <= 12&& j >=10)) {
								System.out.print('*');
							}
							else {
								System.out.print(' ');
							}
						}
						else if( j == 1 || j ==6 || j == 11) {
							System.out.print('*');
						}
						else {
							System.out.print(' ');
						}
						
							
					}
					System.out.println();
				}
				
			}else {
				if(number == 0) status=false;
				else System.out.println("invalid number");
			}
			
		}while(status);
	in.close();
	}
}
