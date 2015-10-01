/**
 * 
 */
package fr.rudelune.prime;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Window for the Project Prime
 *
 * @author rudelune
 * @date 1 oct. 2015
 */
public class Window extends JFrame {
	
	private static final long	serialVersionUID	= 1L;
	
	private static Panel		panel				= new Panel();
	
	public Window() {
		setTitle("Prime");
		setMinimumSize(new Dimension(800, 800));
		setSize(800, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		pack();
		setVisible(true);
	}
	
	private static int		x				= -1;
	private static int		y				= 1;
	private static int		split			= 1;
	private static boolean	positive		= true;
	private static boolean	newLine			= true; // Pas quand il remonte
	
	public static void addPoint(boolean prime) {
		if (positive) {
			if (newLine && x < split) {
				x++;
				if (x == split) {
					positive = false;
					newLine = false;
				}
			} else if (y < split + 1) {
				y++;
				if (y == split + 1) {
					split++;
					newLine = true;
				}
			}
		} else {
			if (y > -split) {
				y--;
			} else if (x > -split) {
				x--;
				if (x == -split) {
					positive = true;
				}
			}
		}
		if (prime) {
			panel.drawPoint(x + 400, y + 400);
			panel.repaint();
		}
	}
}
