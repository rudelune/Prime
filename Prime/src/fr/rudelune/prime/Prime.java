/**
 * 
 */
package fr.rudelune.prime;

/**
 * Prime for the Project Prime
 *
 * @author rudelune
 * @date 30 sept. 2015
 */
public class Prime {
	
	public static void main(String[] args) {
		new Window();
		
		Window.addPoint(1, false);
		Window.addPoint(2, true);
		Window.addPoint(3, true);
		Window.addPoint(4, false);
		
		PrimeFinder.create();
	}
	
}
