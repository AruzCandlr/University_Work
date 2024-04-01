// File: Myprogram.java
// Description: track the 0 at the tail of the binary number converted from the input
// Assignment Number: bonus
//
// ID: 6588108
// Name: ARUS THIENMEE
// Section: 3
// Grader: Anyamanee
//
// On my honor, ARUS THIENMEE, this lab assignment is my own work
// and I have not provided this code to any other students.


import java.util.Scanner;

public class Trailingzero {
	public static void main(String[]args) {
		
		boolean status  = true;
		Scanner in = new Scanner(System.in);
		do {
			int num = in.nextInt();
			
			while(num >= 1024){
				System.out.println("The input should be lower than 1024");
				num = in.nextInt();
			}
			while(num < 0){
				System.out.println("invalid number");
				num = in.nextInt();
			}
			if(num == 0) {
				status = false;
				break;
			}
			String bi = Integer.toBinaryString(num);
			
			int count = 0;
			for(int i = bi.length()-1; i >= 0; i--) {
				if(bi.charAt(i) == '0') {
					count++;
				}
				if(bi.charAt(i) != '0') {
					break;
				}
			}
			System.out.print(bi+"\n"+count);
			
			//System.out.printf("n = %d :\t%s\t= %d\n", num,bi,count);
			
		}while(status);
		in.close();
	}
}
