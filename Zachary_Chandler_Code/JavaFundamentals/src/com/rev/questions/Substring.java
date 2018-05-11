package com.rev.questions;

public class Substring {

	public static void main(String[] args) {
		String n = "Dog";
		int idx = 2;
		
		System.out.println(substring(n, idx));
	}

	public static String substring(String n, int idx) {

		if (idx < 0) {
			throw new IllegalArgumentException();
		}
		
		if (idx > n.length()) {
			throw new IllegalArgumentException();
		}
		
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < idx; i++) {
			result.append(n.charAt(i));
		}
		
		return result.toString();
	}

}
