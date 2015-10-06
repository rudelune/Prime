/**
 * 
 */
package fr.rudelune.prime;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * TextPanel for the Project Prime
 *
 * @author rudelune
 * @date 6 oct. 2015
 */
public class TextPanel extends JPanel {
	
	private static final long	serialVersionUID	= 1L;
	
	public TextPanel() {
		setOpaque(false);
		setSize(Window.width, Window.height);
		setBackground(new Color(255,255,255,255));
		setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawString("Nombres testés   : " + PrimeFinder.getTestedNumbers(), 0, Window.height - 50);
		g.drawString("Nombres premiers : " + PrimeFinder.getPrimeNumbers(), 0, Window.height - 35);
		
	}
	
}
