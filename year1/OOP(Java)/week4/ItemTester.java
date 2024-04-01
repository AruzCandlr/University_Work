
/*
 * DO NOT MODIFY THIS CLASS
 * 
 * File name: ItemTester
 * Description: A tester class to test all methods of the Item class
 * Author: ITCS209 Instructors
 */

public class ItemTester {

	public static void main(String[] args) {
		// Construct a new item, with default value of price and calorie
		Item a = new Item("Chocolate");
		System.out.println("** First Item **");
		// Expected output -> Name: Chocolate, Price: 0.0, Calorie: 0
		a.printItemInfo();
		
		// Set new price and calorie
		a.setPrice(550.00);
		a.setCalorie(200);
		System.out.println("After setting price and calorie");
		// Expected output -> Price: 550.0, Calorie: 200
		System.out.println("Price: " + a.getPrice() + ", Calorie: " + a.getCalorie());
		
		
		// Construct another item with given values
		Item b = new Item("Ice cream", 200.0, 375);
		System.out.println("\n** Second Item **");
		// Expected output -> Name: Ice cream, Price: 200.0, Calorie: 375
		b.printItemInfo();
		
		// Raise a price of item "b" by 20 percent
		b.raisePrice(20);
		System.out.println("After raising price by 20%");
		// Expected output -> New price: 240.0
		System.out.println("New price: " + b.getPrice());
		
		// Calculate price with discount
		double priceA = a.priceWithDiscount();
		double priceB = b.priceWithDiscount();
		System.out.println("\n** Calculate Price with Discount **");
		// Expected output -> Chocolate => 440.0
		System.out.println(a.getName() + " => " + priceA);
		// Expected output -> Ice cream => 216.0
		System.out.println(b.getName() + " => " + priceB);
		
		// Check all items info again
		System.out.println("\n** Final Information **");
		// Expected output ->
		// Name: Chocolate, Price: 550.0, Calorie: 200
		// Name: Ice cream, Price: 240.0, Calorie: 375
		a.printItemInfo();
		b.printItemInfo();
		
	}

}
