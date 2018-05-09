package com.rev.oddeven;

public class OddEven {

	public static void main(String[] args) {
		
		System.out.println(isOdd(7));
	}
	
	public static void isOdd(){
		System.out.println("is odd");
	}
	
	public static boolean isOdd(int n) {
		//bitwise property
		if((n & 1) == 0) 
			return false;
		else
			return true;
	}

}
