package question_9;

import java.util.ArrayList;

public class PrimeNumbers {
	
	/*
	 * Checks if a number is prime
	 */
	private static boolean isPrime(int num) {
		for(int i=2; i<num; i++) {
			if(num%i == 0 && i != num) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		// the ArrayList that stores the numbers from 1 to 100
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=100; i++) {
			list.add(i);
			// Prints out the current number if it's prime
			if(isPrime(i)) System.out.println(i);
		}
	}
}
