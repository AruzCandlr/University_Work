// File: Triangle.java
// Description: <a triangle extended from shape>
// Lab: 9
//
// ID: 6588108 
// Name: Arus Thienmee
// Section: 3
// Grader: 
// On my honor, Arus Thienmee, this project assignment is my own work
// and I have not provided this code to any other students.
public class Triangle extends Shape {

	
	private double base; 
	private double height;
	
	public Triangle() {
		super();
		this.base = 0;
		this.height = 0;
	}
	
	public Triangle(String color, double base, double height) {
		super.setColor(color);
		this.base = base;
		this.height = height;
	}
	
	@Override
	public String toString() {
		
		return "Triangle[base=" + this.base+",height="+this.height+",Shape[color="+super.getColor()+"]]";
	}

	// Override the inherited getArea() to provide the proper implementation
	@Override
	public double getArea() {
		
		return getArea(this.base,this.height);
	}

	public double getArea(double base, double height) {
	
		this.base = base;
		this.height = height;
		return (this.base*this.height)/2;
	}
	
}
