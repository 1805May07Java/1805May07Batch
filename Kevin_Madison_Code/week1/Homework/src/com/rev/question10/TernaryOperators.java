package com.rev.question10;

public class TernaryOperators {
	
	public static void main(String[] args) {
		int num1 = 21;
		int num2 = 20;
		
		int print = findMin(num1, num2);
		
		System.out.println(print +" is the min out of " + num1 +" and "+ num2 +".");
		
	}
	
	public static int findMin(int x, int y) {
		int min = (x > y)?( y ) : ( x );
		return min;
	}

}
