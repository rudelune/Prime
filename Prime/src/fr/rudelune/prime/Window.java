/**
 * 
 */
package fr.rudelune.prime;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

/**
 * Window for the Project Prime
 *
 * @author rudelune
 * @date 1 oct. 2015
 */
public class Window extends JFrame {
	
	public static int			width, height;
	public static int			totalNumbers;
	private static int			middleWidth, middleHeight;
	
	private static final long	serialVersionUID	= 1L;
	
	private static PrimePanel	primePanel;
	private static TextPanel	textPanel;
	
	public Window() {
		setTitle("Prime");
		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment()
			.getScreenDevices()[0];
		width = device.getDisplayMode().getWidth();
		middleWidth = width / 2;
		height = device.getDisplayMode().getHeight();
		middleHeight = height / 2;
		totalNumbers = width < height ? (width - 41) * (width - 41) : (height - 41) * (height - 41);
		primePanel = new PrimePanel();
		textPanel = new TextPanel();
		this.setUndecorated(true);
		device.setFullScreenWindow(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		primePanel.setLayout(null);
		textPanel.setLayout(null);
		primePanel.add(textPanel);
		setContentPane(primePanel);
		
		validate();
		setVisible(true);
		requestFocus();
		
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE_KEY");
		getRootPane().getActionMap().put("ESCAPE_KEY", escapeAction);
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "SPACE_KEY");
		getRootPane().getActionMap().put("SPACE_KEY", spaceAction);
	}
	
	private static int		x			= -1;
	private static int		y			= 1;
	private static int		split		= 1;
	private static boolean	positive	= true;
	private static boolean	newLine		= true;
	
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
			primePanel.drawPoint(x + middleWidth, y + middleHeight);
			primePanel.repaint();
			textPanel.repaint();
		}
	}
	
	private final AbstractAction	escapeAction	= new AbstractAction() {
														private static final long	serialVersionUID	= 1L;
														
														@Override
														public void actionPerformed(ActionEvent e) {
															PrimeFinder.stop();
															dispose();
														}
													};
	
	private final AbstractAction	spaceAction		= new AbstractAction() {
														private static final long	serialVersionUID	= 1L;
														
														@Override
														public void actionPerformed(ActionEvent e) {
															PrimeFinder.togglePause();
														}
													};
}
