package com.ex.exercises;

public class Fibonacci {
	//sequence where each number is the sum of the prior two numbers
	
	public int fib(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fib(n-1) + fib(n-2);
	}

	/*
	 * fib 4
	 * fib(3) + fib(2)
	 * fib(2)		 + fib(1) + fib(1) + fib(0)
	 * fib(1) + fib(0) + 1 + 	1 	+    0
	 *  1 + 0 + 1 + 1 + 0 --> 3
	 */

}
