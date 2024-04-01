
// File: Arus Thienmee
// Description: print the rectangle data(about coordinates,width and height)
// Assignment Number: 1.2
//
// ID: 6588108
// Name: Arus Thienmee
// Section: 3
// Grader: Anyamanee
//
// On my honor, Arus Thienmee, this lab assignment is my own work
// and I have not provided this code to any other students.
import java.awt.Rectangle;

public class GrowSquarePrinter {

	
	
	
	public static void main (String[]args) {
		Rectangle square = new Rectangle(100,100,50,50);
		
		System.out.println(square);
	
		square.grow(25,25);
		square.translate(25, 25);
		
		System.out.println(square);
	}
}
