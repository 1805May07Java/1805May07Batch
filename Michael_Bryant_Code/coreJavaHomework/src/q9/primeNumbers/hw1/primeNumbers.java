package q9.primeNumbers.hw1;

import java.util.ArrayList;

public class primeNumbers {
	
	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int start = 1;
		int end = 100;
		
		for(int i=start; i < end; i++) {
			boolean isPrime = true;
			for(int j = 2; j < i; j++) {
				if(i % j == 0) {
					isPrime= false;
					break;
				}
			}
			if(isPrime) {primes.add(i);}
		}
		
		System.out.println(primes);
	}

}
