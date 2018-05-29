package com.hw.q6;

public class Even {
	
	public static boolean isEven(int number) {
		
		//bitwise shift to least significant digit which is 0 
		//for even numbers and 1 for odd
		boolean x = (number & (1 << (32))) != 0;
		
		//flip the boolean value since this is a check on eveness
		return !x;
	}
	
}
