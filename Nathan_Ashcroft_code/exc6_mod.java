package com.rev.questions;

public class exc6_mod {
	//Write a program to determine if an integer is even without using the modulus operator (%)
	public boolean mod(int tst) {
		boolean isEven;
		
		isEven = ((tst & 1) == 0)? true : false;
		
		return isEven;
	}
}
