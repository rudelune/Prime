/**
 * 
 */
package fr.rudelune.prime;

import java.util.ArrayList;
import java.util.List;

/**
 * PrimeFinder for the Project Prime
 *
 * @author rudelune
 * @date 1 oct. 2015
 */
public class PrimeFinder implements Runnable {
	
	@Override
	public void run() {
		while (a <= 600000) {
			if (isPrime(a)) {
				addPrime(a);
			}
			a += 2;
			Window.addPoint(false);
			Window.addPoint(false);
			
			if (isPrime(a)) {
				addPrime(a);
			}
			a += 4;
			Window.addPoint(false);
			Window.addPoint(false);
			Window.addPoint(false);
			Window.addPoint(false);
		}
		Thread.currentThread().interrupt();
	}
	
	private static List<Integer>	primes	= new ArrayList<Integer>();
	
	private static int				a		= 5;
	
	private static boolean isPrime(int number) {
		for (int i = 0; i < primes.size(); i++) {
			if (number % primes.get(i) == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static void addPrime(int number) {
		primes.add(number);
		Window.addPoint(true);
		// System.out.println(number);
	}
	
	public static int getTestedNumbers() {
		return a;
	}
	
}
