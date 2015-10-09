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
		while (!mustStop && a < Window.totalNumbers) {
			if (!pause) {
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
		}
		Thread.currentThread().interrupt();
	}
	
	private static List<Integer>	primes	= new ArrayList<Integer>();
	
	private static int				a		= 5;
	
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
	
	private static void addPrime(int number) {
		primes.add(number);
		Window.addPoint(true);
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
