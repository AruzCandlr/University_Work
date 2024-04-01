// File: Circle.java
// Description: <a circle extended from shape>
// Lab: 9
//
// ID: 6588108 
// Name: Arus Thienmee
// Section: 3
// Grader: 
// On my honor, Arus Thienmee, this project assignment is my own work
// and I have not provided this code to any other students.

public class Circle extends Shape {

	
	private double radius; 

	
	public Circle() {
		super();	
		this.radius = 0;
	}
	
	public Circle(String color, double  radius) {
		super.setColor(color);
		this. radius = radius;
	}
	
	@Override
	public String toString() {
		
		return "Circle[radius=" + this.radius +",Shape[color="+super.getColor()+"]]";
	}

	// Override the inherited getArea() to provide the proper implementation
	@Override
	public double getArea() {
		
		return getArea(this.radius);
	}

	public double getArea(double  radius) {
		
		this.radius= radius;

		return Math.PI * Math.pow(radius, 2.0);
	}
	
}
