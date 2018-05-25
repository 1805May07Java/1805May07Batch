package com.rev.Q9;

import java.util.ArrayList;

public class Primes {

	public static void main(String[] args) {
		Primes.printPrimes();
	}
	
	public static boolean[] notPrime = new boolean[100];

	public static void printPrimes() {
		ArrayList<Integer> nums = new ArrayList<Integer>(100);
		System.out.println(1);
		nums.add(1);
		for (int i = 2; i < 100; i++) {
			if(isPrime(i))
				System.out.println(i);
			nums.add(i);
		}
		nums.add(100);
		System.out.print("Array List: "+ nums);

	}

	private static boolean isPrime(int i) {
		if (notPrime[i] == false) {
			for(int j = 2; j*i < 100 ; j++) {
				notPrime[j*i] = true;
			}
			return true;
		}
		else return false;
	}

}
