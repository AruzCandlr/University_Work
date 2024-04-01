// File: <NAME OF FILE>
// Description: <A DESCRIPTION OF YOUR PROGRAM>
// Assignment Number: <e.g., 1 – 13>
//
// ID: <YOUR STUDENT ID>
// Name: <YOUR FULLNAME>
// Section: <YOUR SECTION e.g., 1, 2, or 3>
// Grader: <YOUR GRADER’S NAME>
//
// On my honor, <YOUR FULLNAME>, this lab assignment is my own work
// and I have not provided this code to any other students.


//********************** DO NOT MODIFY EXCEPT WHERE INDICATED **************************//
public abstract class Object3D {
	
	//*** Constants and enum ***//
	public static final double G = 9.8; //Gravitational force (G) = 9.8 m/s^2
	public static final double PI = 3.14;	//Pi 
	public static enum Material {Water, Rubber, Gold, OakWood, Butter, Wax, Soap, Air, Oxygen, Hydrogen, Helium};	//All the material types
	public static final double[] DENSITIES = {1000, 1522, 19320, 760, 911, 961, 801, 1.225, 1.43, 0.08988, 0.1664}; //Corresponding densities
	
	//Class variables
	private Material matType = null;	//Material of this Object3D
	private String name = null;			//Name of this Object3D
	
	//Constructor
	public Object3D(String _name, Material _matType)
	{
		this.name = _name;
		this.matType = _matType;
	}
	
	//Return the material type
	public Material getMaterial()
	{
		return this.matType;
	}
	
	//Return the name
	public String getName()
	{
		return this.name;
	}
	
	//Cool way to display this Object3D
	public String toString()
	{
		return "["+name+"("+matType.toString()+"), "
				+"V: "+String.format("%,.2f",this.getVolume())+", "
				+"S: "+String.format("%,.2f",this.getSurface())+", "
				+"M: "+String.format("%,.2f",this.getMass())+", "
				+"PE from 9m Height: "+String.format("%,.2f",this.getDroppingPotentialEngery(9))+", "
				+"CanFloat: "+this.canFloat()+", "
				+"CanFly: "+this.canFly()+"]";
	}
	
	/**
	 * Calculate and return the mass of this Object3D
	 */
	public double getMass()
	{
		return this.getVolume()*Object3D.DENSITIES[this.getMaterial().ordinal()];
	}
	
	/**
	 * Calculate and return the PE from dropping this Object3D from the given height 
	 */
	public double getDroppingPotentialEngery(double height)
	{
		return this.getMass()*Object3D.G*height;
	}
	
	/**
	 * Return true of this Object3D can float on water; false otherwise.
	 */
	public boolean canFloat()
	{
		//****************** YOUR CODE HERE *************************//
		return false;
		//***********************************************************//
	}
	
	/**
	 * Return true of this Object3D can fly in the air; false otherwise.
	 */
	public boolean canFly()
	{
		//****************** YOUR CODE HERE *************************//
		return false;
		//***********************************************************//
	}
	
	//Abstract Methods
	public abstract double getVolume();	//Calculate and return the volume of this object
	public abstract double getSurface(); //Calculate and return the surface area of this object
}
