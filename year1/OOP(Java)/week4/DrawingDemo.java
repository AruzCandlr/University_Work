/*
 * DO NOT MODIFY THIS CLASS 
 * You can only comment or uncomment the sourcecode
 * 
 * File name: DrawingDemo
 * Description: A tester class to test components inside JFrame
 * Author: ITCS209 Instructors
 */

import java.util.Scanner;
import javax.swing.JFrame;

public class DrawingDemo {

	public static void main(String[] args) {
		// Construct a frame with the size of 500 * 500
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		
		// End this program, when close the frame window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Take an input from a user
		System.out.print("Input number 2 to draw two rectangles, or 4 to draw four rectangles in the frame window: ");
		Scanner scan = new Scanner(System.in);
		int task = scan.nextInt();
		System.out.print("Input x: ");
		int x = scan.nextInt();
		System.out.print("Input y: ");
		int y = scan.nextInt();
		System.out.print("Input width: ");
		int width = scan.nextInt();
		System.out.print("Input height: ");
		int height = scan.nextInt();
		
		
		switch (task) {
			// Construct TwoRectangleComponent to draw two rectangles inside the frame window
			case 2:
				TwoRectangleComponent simple = new TwoRectangleComponent(x, y, width, height);
				frame.add(simple);
				frame.setVisible(true);
				break;
				
			// Uncomment this code below (case 4 option) to test FourRectangleComponent class
		
			case 4:
				FourRectangleComponent fourRec = new FourRectangleComponent(x, y, width, height);
				frame.add(fourRec);
				frame.setVisible(true);
				break;
			
			default:
				System.out.println("Invalid input");
		}
		scan.close();
	}

}
