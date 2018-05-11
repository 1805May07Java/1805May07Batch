package com.rev.questions;

public class Minimum {

	public static void main(String[] args) {
		int n1 = 3;
		int n2 = 3;
		
		System.out.println(min(n1, n2));
	}

	
	public static int min(int n1, int n2) {
		return n1 < n2 ? n1 : n2 < n1 ? n2 : n1;
	}
}
