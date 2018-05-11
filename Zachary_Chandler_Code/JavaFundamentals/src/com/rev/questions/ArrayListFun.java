package com.rev.questions;

import java.math.BigInteger;
import java.util.ArrayList;

public class ArrayListFun {
	
	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++) {
			ints.add(i);
		}
		
		System.out.println(ints);

		int accumulatorE = 0;
		int accumulatorO = 0;
		
		for (int x : ints) {
			if ((x & 1) == 0) {
				accumulatorE += x;
			} else {
				accumulatorO += x;
			}
		}

		System.out.println("Evens sum: " + accumulatorE);
		System.out.println("Odds sum: " + accumulatorO);
		
		ArrayList<Integer> primes = new ArrayList<>();
		
		for (int x : ints) {
			if (new BigInteger("" + x).isProbablePrime(100)) {
				primes.add(x);
			}
		}
		
		ints.removeAll(primes);
		
		System.out.println(ints);
		
	}
}
