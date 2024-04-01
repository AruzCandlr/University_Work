
// File: Arus Thienmee
// Description: print the rectangle data(about coordinates,width and height)
// Assignment Number: 1.3
//
// ID: 6588108
// Name: Arus Thienmee
// Section: 3
// Grader:Anyamanee
//
// On my honor, Arus Thienmee, this lab assignment is my own work
// and I have not provided this code to any other students.

import java.awt.Rectangle;

public class IntersectionPrinter {

	public static void main(String[]args){
		
		Rectangle r1 = new Rectangle(100,100,50,50);
		Rectangle r2 = new Rectangle(90,100,50,50);
		System.out.println(r1);
		System.out.println(r2);
		if(r1.intersects(r2)) {
			System.out.println(r1.createIntersection(r2));
		}
		
		else{
			System.out.println("DO NOT OVERLAP");
		}
		// use __.intersect(__) which will return boolean expression true if r1 and r2 are intersected
		
	}
}
