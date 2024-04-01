
/*
 * DO NOT MODIFY THIS CLASS
 * 
 * File name: SimpleRectangleComponent
 * Description: An example component class to draw one rectangle, 
 * 				see how to construct this class in DrawingDemo.java
 * Author: ITCS209 Instructors
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class TwoRectangleComponent extends JComponent{
	
		private int x, y, w, h;
		
		public TwoRectangleComponent(int _x, int _y, int _w, int _h) {
			this.x = _x;
			this.y = _y;
			this.w = _w;
			this.h = _h;
		}
	
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			
			Rectangle box = new Rectangle(x, y, w, h);
			g2.draw(box);
			
			//for bonus
			// create duplicate of the pre-translate rectangle
			Rectangle prebox = new Rectangle(x, y, w, h);
			
			box.translate(25, 50);
			g2.draw(box);
			
			//paint the intersection point
			g2.fill( prebox.createIntersection(box));
			
}
}
