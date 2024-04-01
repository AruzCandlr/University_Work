

public class ShapeTester {
	public static void main(String[] args) {
		Shape s1 = new Rectangle("red", 4, 5);
		System.out.println(s1);  							// Run Rectangle's toString()
		System.out.println("Area is " + s1.getArea());  	// Run Rectangle's getArea()

		// Uncomment this section when you finish the class Triangle for testing
	      Shape s2 = new Triangle("blue", 4, 5);
	      System.out.println(s2);  							// Run Triangle's toString()
	      System.out.println("Area is " + s2.getArea());  	// Run Triangle's getArea()
		 

		Shape s3 = new Shape("blue"); 
		System.out.println("--Test superclass method--");
		System.out.println(s3);  							// Run Triangle's toString()
		System.out.println("Area is " + s3.getArea());  	// Run Triangle's getArea()

		Rectangle s4 = new Rectangle();  
		s4.setColor("green");
		System.out.println("--Test overload method--");
		System.out.println("Area is " + s4.getArea(5.0, 10.0));  	// Run Rectangle's getArea()
		System.out.println(s4);  									// Run Rectangle's toString()

		// Uncomment this section when you finish the class Triangle for testing
		Triangle s5 = new Triangle(); 
		s5.setColor("yellow");
		System.out.println("--Test overload method--");
		System.out.println("Area is " + s5.getArea(5.0, 10.0));  	// Run Triangle's getArea()
		System.out.println(s5);  									// Run Triangle's toString()
		
		
		System.out.print("\n\n//-------------------bonus-------------------//\n\n\n");
		//bonus
		Shape s6 = new Circle("rainbow",1.0); 
		System.out.println("Area is " + s6.getArea());  	
		System.out.println(s6); 
		System.out.println("\n"); 
		Circle s7 = new Circle(); 
		s7.setColor("super kira kira kyun kyun rainbow desu!!");
		System.out.println("--Test overload method--");
		System.out.println("Area is " + s7.getArea(1.0));  
		System.out.println(s7);  
		System.out.println("\n"); 
		
		Shape s8 = new Ellispe("rainbow",1.0,2.0); 
		System.out.println("Area is " + s8.getArea());  	
		System.out.println(s8); 
		System.out.println("\n"); 
		
		Ellispe s9 = new Ellispe(); 
		s9.setColor("super kira kira kyun kyun rainbow desu!!");
		System.out.println("--Test overload method--");
		System.out.println("Area is " + s9.getArea(5.0, 10.0));  	
		System.out.println(s9);  
	}
}
