/**
 * 
 */
package fr.rudelune.prime;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * PrimePanel for the Project Prime
 *
 * @author rudelune
 * @date 1 oct. 2015
 */
public class PrimePanel extends JPanel {
	
	private static final long	serialVersionUID	= 1L;
	
	private static final int	whiteRGB			= Color.WHITE.getRGB();
	
	private BufferedImage		image;
	
	public PrimePanel() {
		setBackground(Color.BLACK);
		setLocation(Window.width, Window.height);
		setSize(Window.width, Window.height);
		image = new BufferedImage(Window.width, Window.height, BufferedImage.TYPE_BYTE_BINARY);
		validate();
		setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
	
	public void drawPoint(int x, int y) {
		image.setRGB(x, y, whiteRGB);
	}
	
}
