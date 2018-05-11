package com.rev.questions;

public class Fibonacci {
	
	public static void main(String[] args) {
		for (int i = 0; i < 26; i++) {
			
			System.out.println(i + "th fibonacci = " + fibonacci(i));
			
		}
	}
	
	/**
	 * Calculates the nth fibonacci number.
	 * 
	 * @throws IllegalArgumentException if n is negative.
	 */
	public static int fibonacci(int n) throws IllegalArgumentException {
		if (n < 0) {
			throw new IllegalArgumentException("Example.fibonacci does not accept negative numbers.");
		}
		
		int current = 0;
		int next = 1;
		
		for (int i = 0; i < n; i++) {
			int temp = current + next;
			
			current = next;
			next = temp;
		}
		
		return current;
	}
}
