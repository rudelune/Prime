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
	
	private static boolean	mustStop	= false;
	private static boolean	pause		= false;
	
	public static void create() {
		new Thread(new PrimeFinder()).start();
	}
	
	private PrimeFinder() {
	}
	
	@Override
	public void run() {
		while (!mustStop) {
			if (!pause) {
				addProbablyPrime(++a);
				Window.addPoint(++a, false);
				
				addProbablyPrime(++a);
				Window.addPoint(++a, false);
				Window.addPoint(++a, false);
				Window.addPoint(++a, false);
			}
		}
		Thread.currentThread().interrupt();
	}
	
	private static List<Integer>	primes	= new ArrayList<Integer>();
	
	private static int				a		= 4;
	
	private static boolean isPrime(int number) {
		int squaredRoot = (int) Math.floor(Math.sqrt(number));
		for (int i = 0; i < primes.size(); i++) {
			if (number % primes.get(i) == 0) {
				return false;
			} else if (primes.get(i) >= squaredRoot) {
				return true;
			}
		}
		return true;
	}
	
	private static void addProbablyPrime(int number) {
		if (isPrime(number)) {
			primes.add(number);
			Window.addPoint(number, true);
		} else {
			Window.addPoint(number, false);
		}
	}
	
	public static int getTestedNumbers() {
		return a;
	}
	
	public static int getPrimeNumbers() {
		return primes.size() + 2;
	}
	
	public static void stop() {
		mustStop = true;
	}
	
	public static void togglePause() {
		pause = !pause;
	}
}
