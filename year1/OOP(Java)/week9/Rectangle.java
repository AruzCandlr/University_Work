// File: Rectangle.java
// Description: <a rectangle extended from shape>
// Lab: 9
//
// ID: 6588108 
// Name: Arus Thienmee
// Section: 3
// Grader: 
// On my honor, Arus Thienmee, this project assignment is my own work
// and I have not provided this code to any other students.

public class Rectangle extends Shape {
	// Private member variables
	private double length;
	private double width;
	
	// Constructors
	public Rectangle() {
		
		super();
		this.length = 0;
		this.width = 0;
		
	}

	public Rectangle(String color, double length, double width) {
		
		super.setColor(color);
		this.length = length;
		this.width = width;
	}

	@Override
	public String toString() {
		
		return "Rectangle[length=" + this.length+",width="+this.width+",Shape[color="+super.getColor()+"]]";
	}

	// Override the inherited getArea() to provide the proper implementation
	@Override
	public double getArea() {
		
		return getArea(this.length,this.width);
	}

	public double getArea(double length, double width) {
	
		this.length = length;
		this.width = width;
		return this.length*this.width;
	}
}
