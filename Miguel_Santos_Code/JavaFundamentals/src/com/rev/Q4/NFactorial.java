package com.rev.Q4;

public class NFactorial {

	public static int factN(int n) {
		
		int fact = 1;						//Initialize factorial of N with 1, not 0
		for (int i = 1; i <= n; i++) {
			fact = fact*i;					//Multiply to factorial starting from 1 all the way to N
		}
		//System.out.println(fact);			Print Factorial of N
		return fact;						//return N
	}
	
}
