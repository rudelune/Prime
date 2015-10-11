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
	public static int			totalNumbers, hugeMaxNumbers;
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
		totalNumbers = width < height ? (width - 1) * (width - 1) : (height - 1) * (height - 1);
		hugeMaxNumbers = width > height ? (width - 1) * (width - 1) : (height - 1) * (height - 1);
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
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0), "SCREEN");
		getRootPane().getActionMap().put("SCREEN", screenAction);
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "SAVE");
		getRootPane().getActionMap().put("SAVE", saveAction);
	}
	
	private static int		x			= 0;
	private static int		y			= 0;
	private static int		split		= 0;
	private static boolean	positive	= true;
	private static boolean	newLine		= false;
	
	public static void addPoint(int number, boolean prime) {
		if (number > Window.hugeMaxNumbers) {
			textPanel.repaint();
			return;
		}
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
			int finalX = x + middleWidth;
			int finalY = y + middleHeight;
			if (number > Window.totalNumbers) {
				if (finalX >= 0 && finalX < width && finalY >= 0 && finalY < height) {
					primePanel.drawPoint(x + middleWidth, y + middleHeight);
					primePanel.repaint();
					textPanel.repaint();
				}
			} else {
				primePanel.drawPoint(x + middleWidth, y + middleHeight);
				primePanel.repaint();
				textPanel.repaint();
			}
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
	
	private final AbstractAction	screenAction	= new AbstractAction() {
														private static final long	serialVersionUID	= 1L;
														
														@Override
														public void actionPerformed(ActionEvent e) {
															primePanel.saveImage();
														}
													};
	
	private final AbstractAction	saveAction		= new AbstractAction() {
														private static final long	serialVersionUID	= 1L;
														
														@Override
														public void actionPerformed(ActionEvent e) {
															PrimeFinder.savePrimes();
														}
													};
}
