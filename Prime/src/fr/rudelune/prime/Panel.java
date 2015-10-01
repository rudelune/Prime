/**
 * 
 */
package fr.rudelune.prime;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;

/**
 * Panel for the Project Prime
 *
 * @author rudelune
 * @date 1 oct. 2015
 */
public class Panel extends JPanel {
	
	private static final long	serialVersionUID	= 1L;
	private List<Point>			points				= new CopyOnWriteArrayList<Point>();
	
	public Panel() {
		setBackground(Color.BLACK);
		setLocation(800, 800);
		setSize(800, 800);
		this.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawString("Nombres testés : " + PrimeFinder.getTestedNumbers(), 0, 750);
		g.drawString("Nombres premiers : " + points.size(), 0, 765);
		g.setColor(Color.RED);
		g.drawLine(400, 400, 400, 400);
		g.setColor(Color.YELLOW);
		Iterator<Point> iter = points.iterator();
		while (iter.hasNext()) {
			iter.next().draw(g);
		}
	}
	
	public void drawPoint(int x, int y) {
		points.add(new Point(x, y));
	}
	
}
