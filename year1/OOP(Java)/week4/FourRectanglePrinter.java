// Complete this file to construct a rectangle and translate it three times to form one large rectangle

// File: Arus Thienmee
// Description: print the rectangle data(about coordinates,width and height)
// Assignment Number: 1.1
//
// ID: 6588108
// Name: Arus Thienmee
// Section: 3
// Grader: Anyamanee
//
// On my honor, Arus Thienmee, this lab assignment is my own work
// and I have not provided this code to any other students.


import java.awt.Rectangle;

public class FourRectanglePrinter {

	public static void main(String[] args) {
		
		Rectangle box;
		
		box = new Rectangle(100,50,150,200);
	
		
		// Print box information using println method
		System.out.println(box);
		box.translate(150, 0);
		System.out.println(box);
		box.translate(0, 200);
		System.out.println(box);
		box.translate(-150, 0);
		System.out.println(box);
		
		// Call translate method to move the box and print the box information after each move
		// Repeate thses steps three times to form a large rectangle

	}

	

}
