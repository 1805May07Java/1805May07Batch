package com.rev.evenchecker;

public class Evenchecker {
	//Hard code number to check
	public static void main(String[] args) {
		System.out.println(Evenchecker.evenCheck(10));
	}
	public static boolean evenCheck(int num) {
		//Divide number by two
		int quotient = num/2;
		//Multiply by two and check for equality. If value is even, it will return true.
		if ((quotient*2) == num){
			return true;
		}
		else {
			return false;
		}
		
	}
}