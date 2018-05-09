package com.rev.minnum;

public class MinNum {

	public static void main(String[] args) {
		//System.out.println("in main");
		System.out.println(min(3, 7));
		System.out.println(min(7,3));
		System.out.println(min(1,1));
	}
	
	public static int min(int a, int b) {
		return a < b ? a : (a == b) ? a : b;
	}

}
