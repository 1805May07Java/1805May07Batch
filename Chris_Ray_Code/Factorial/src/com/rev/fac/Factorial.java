package com.rev.fac;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(calculateFac(7));

	}

	public static long calculateFac(int n) {
	    
	    return (n < 2) ? 1 : n * calculateFac(n - 1);
	}
}
