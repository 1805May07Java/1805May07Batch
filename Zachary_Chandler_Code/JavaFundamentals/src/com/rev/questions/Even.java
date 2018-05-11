package com.rev.questions;

public class Even {

	public static void main(String[] args) {
		int n = 32;// Integer.parseInt(args[0]);
		
		System.out.println(even(n));
	}
	
	public static String even(int n) {
		return (n & 1) == 0 ? "even" : "odd";
	}
	
}
