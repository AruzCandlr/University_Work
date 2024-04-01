
// File: Arus Thienmee
// Description: create new method to be used in ItemTester.java
// Assignment Number: 2
//
// ID: 6588108
// Name: Arus Thienmee
// Section: 3
// Grader: Anyamanee
//
// On my honor, Arus Thienmee, this lab assignment is my own work
// and I have not provided this code to any other students.
public class Item {

	private String a = null;
	private double b = 0;
	private int c = 0;
	
	public Item(String name) {
		a = name;
	}
	
	public Item(String name,double price, int cal) {
		a = name;
		b = price;
		c = cal;
	}
	
	public String getName() {
		return a;
		// return item’s name
	}
	public double getPrice() {
		return b;
		// return item’s price
	}
	public int getCalorie() {
		return c;
		// return item’s calorie
	}
	public void setPrice(double price) {
		// set new value to item’s price
		b = price;
	}
	public void setCalorie(int cal) {
		// set new value to item’s calorie
		c = cal;
	}
	public void printItemInfo() {
		System.out.println("Name: "+ a +", Price: " + b + ", Calorie:" + c);
	}
	// print all information of an item in the following format
	// Name: xxx, Price: yyy, Calorie: zzz
	public void raisePrice(double percent) {
		b+=((b*percent)/100);
	}
	// raise the item’s price by a certain percentage
	public double priceWithDiscount() {
		double x = b;
		if(b >= 100 && b <=500) {
			x-=((x*10)/100);
		}
		else if(b >500) {
			x-=((x*20)/100);
		}
		
		return x;
		
	}
}
