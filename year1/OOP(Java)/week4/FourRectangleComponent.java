
// File: Arus Thienmee
// Description: print the rectangle data(about coordinates,width and height)
// Assignment Number: bonus
//
// ID: 6588108
// Name: Arus Thienmee
// Section: 3
// Grader: Anyamanee
//
// On my honor, Arus Thienmee, this lab assignment is my own work
// and I have not provided this code to any other students.

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class FourRectangleComponent extends JComponent{
	
		private int x, y, w, h;
		
		public FourRectangleComponent(int _x, int _y, int _w, int _h) {
			this.x = _x;
			this.y = _y;
			this.w = _w;
			this.h = _h;
		}
	
		public void paintComponent(Graphics g) {
			Graphics2D g4 = (Graphics2D) g;
			
			Rectangle box = new Rectangle(x, y, w, h);
			g4.draw(box);
			box.translate(w, 0);
			g4.draw(box);
			box.translate(0, h);
			g4.draw(box);
			box.translate(-w, 0);
			g4.draw(box);
		}
}
