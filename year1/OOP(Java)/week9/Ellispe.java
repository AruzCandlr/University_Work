// File: Ellispe.java
// Description: <an ellispe extended from shape>
// Lab: 9
//
// ID: 6588108 
// Name: Arus Thienmee
// Section: 3
// Grader: 
// On my honor, Arus Thienmee, this project assignment is my own work
// and I have not provided this code to any other students.


public class Ellispe extends Shape {

	
	private double radiusA; 
	private double radiusB;
	
	public Ellispe() {
		super();	
		this. radiusA = 0;
		this. radiusB = 0;
	
	}
	
	public Ellispe(String color, double radiusA, double radiusB) {
		super.setColor(color);
		this. radiusA = radiusA;
		this. radiusB = radiusB;
	}
	
	@Override
	public String toString() {
	
		return "Ellispe[radiusA=" + this.radiusA +"radiusB=" + this.radiusB +",Shape[color="+super.getColor()+"]]";
	}

	// Override the inherited getArea() to provide the proper implementation
	@Override
	public double getArea() {
		
		return getArea(this.radiusA,this.radiusB);
	}

	public double getArea(double  rA, double rB ){
		
		this.radiusA= rA;
		this.radiusB= rB;

		return Math.PI * this.radiusA * this.radiusB;
	}
	
}
