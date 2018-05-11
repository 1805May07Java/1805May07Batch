package com.rev.questions;

import java.math.BigInteger;
import java.util.ArrayList;

public class Primes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(primes(100));
		
	}
	
	public static ArrayList<Integer> primes(int n) {

		ArrayList<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			if (new BigInteger("" + i).isProbablePrime(100)) {
				result.add(i);
			}
		}
		
		return result;
	}

}
