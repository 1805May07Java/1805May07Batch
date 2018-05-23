package com.rev.excersizes;

public class understandingexeptions {
	public static void main(String[] args) {
		doSomething();
		//int x = doSomething();
	}
	
	static int doSomething() {
		try {
			int [] arr = new int[5];
			arr[10] = 19;
			return 0;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			return 0;
		}
		finally {
			System.out.println("in finally block");
		}
	}
	
	void test() {
		
	}
}
