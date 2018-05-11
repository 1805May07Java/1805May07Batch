package com.rev.questions;

public class StringReverse {

	public static void main(String args[]) {
		String n = "Dog";
		
		System.out.println(reverseString(n));
	}

	public static String reverseString(String n) {
		
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < n.length(); i++) {
			result.append(n.charAt(n.length() - i - 1));
		}
		
		return result.toString();
	}
}
