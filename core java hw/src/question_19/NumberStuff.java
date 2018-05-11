package question_19;

import java.util.ArrayList;

public class NumberStuff {

	/*
	 * Checks if a number is prime
	 * Returns true if the number is prime
	 * Returns false is the number is not prime
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
		// Create an ArrayList named list, and fill it with int's from 1 to 10
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			list.add(i);
		}
	
		/*
		 * Create two int variables to store the summation of the even and odd numbers
		 * Use a for-loop to traverse the ArrayList and increment to 'even' or 'odd'.
		 */
		int even = 0, odd = 0;
		for(int i : list) {
			if(i%2 == 0)
				even += i;
			else
				odd += i;
		}
		
		
		/*
		 * Since we'll be removing some elements, I thought it best to use a regular for-loop
		 * We traverse the ArrayList, and when we hit a prime number we remove the element
		 * Since the elements get shifted backwards, we need to properly manage where our index points
		 * This is done simply but decrementing i by 1 (then letting the for-loop increment it by 1, thereby staying in the same index)
		 */
		for(int i=1; i<list.size(); i++) {
			if(isPrime(list.get(i))) {
				list.remove(i);
				i--;
			}
		}
		System.out.println("Even numbers added: " + even);
		System.out.println("Odd numbers added: " + odd);
		System.out.println(list);
	}
}
