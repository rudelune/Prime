/**
 * 
 */
package fr.rudelune.prime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
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
	
	@Override
	public void run() {
		while (!mustStop) {
			if (!pause) {
				addMaybePrime(++a);
				Window.addPoint(++a, false);
				
				addMaybePrime(++a);
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
	
	private static void addMaybePrime(int number) {
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
	
	public static void savePrimes() {
		File file = new File("prime_" + new Date().getTime() + ".txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			OutputStream os = new FileOutputStream(file);
			PrintStream printStream = new PrintStream(os);
			printStream.println("2\n3");
			List<Integer> primesCopy = new ArrayList<Integer>();
			primesCopy.addAll(primes);
			for (int prime : primesCopy) {
				printStream.println(prime + "");
			}
			printStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
