package com.rev.questions;

public class Factorial {

	public static void main(String[] args) {
		int n = 20; //Integer.parseInt(args[0]);
		
		System.out.println(factorial(n));
		
	}
	
	public static int factorial(int n) {
		
		if (n < 0) {
			throw new IllegalArgumentException("Example.fibonacci does not accept negative numbers.");
		}
		
		int result = 1;
		
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		
		return result;
		
	}

}
