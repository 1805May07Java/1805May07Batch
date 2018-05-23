package com.rev.questions;

public class exc4_Factorial {
	
	//Write a program to compute N factorial.
	public int fact(int n) {
		int f = 1;
		
		while (n != 0) {
			f *= n;
			n--;
		}
		
		return f;
	}
}
