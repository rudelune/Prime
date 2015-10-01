/**
 * 
 */
package fr.rudelune.prime;

import java.awt.Graphics;

/**
 * Point for the Project Prime
 *
 * @author rudelune
 * @date 1 oct. 2015
 */
public class Point {
	
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {
		g.drawLine(x, y, x, y);
	}
	
}
