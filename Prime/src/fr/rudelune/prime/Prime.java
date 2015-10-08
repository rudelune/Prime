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
		
		Window.addPoint(false);	// 1
		Window.addPoint(true);	// 2
		Window.addPoint(true);	// 3
		Window.addPoint(false);	// 4
		
		PrimeFinder.create();
	}
	
}
