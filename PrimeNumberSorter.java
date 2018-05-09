package com.rev.primes;

import java.util.ArrayList;

public class PrimeNumberSorter {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for(int i = 1; i <=100; i++) {
			nums.add(i); //used to be new Integer(i) in Java 8
		}
		
		for(int i = 0; i < 100; i++) {
			if(PrimeNumberSorter.isPrime(nums.get(i))) {
				primes.add(nums.get(i));
			}
		}
		
		System.out.println(nums);
		System.out.println(primes);

	}
	
	
	public static boolean isPrime(Integer n) {
		
		for(int i=2; i < n; i++) {
			if(n % i == 0)
				return false;
		}
		return true;
	}

}
