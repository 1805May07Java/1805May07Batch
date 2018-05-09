package com.ex.exceptions;

public class UnderstandingExceptions {

	public static void main(String[] args) {
		int x = doSomething();
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
			System.out.println("in finally block");
		}
	}

	void test() {

	}
}

/*
resources:
https://www.javabrahman.com/corejava/understanding-exception-hierarchy-java-tutorial/
 */