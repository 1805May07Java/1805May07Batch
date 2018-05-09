package com.exe.UnderstandingExceptions;

public class UnderstandingExceptions {
	public static void main(String[] args) {
		
	}
	
	static int doSomething() {
		try {
			int[] arr = new int[5];
			arr[10] = 19;
			return 0;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			return 0;
		}
		finally {
			System.out.println("IN FINALLY BLOCK");
		}
		
	}
	
	static void test() {
		
	}
}
