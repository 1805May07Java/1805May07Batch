/*
 * AlphaDemo.java
 * Author: Cole Vikupitz
 * 
 * Exercise 18: A demonstration of the implemented methods
 * described in exercise 18 using an abstract superclass and
 * a concrete child class.
 */

package com.revature.exercise18;

public class AlphaDemo {

	public static void main(String[] args) {
		
		// Create instance of class with the methods
		AlphaChild ac = new AlphaChild();
		// Create array of testing strings
		String[] strArray = {"This", "is", "A", "TeSt", "!@#$"};
		
		// Test hasUpperCase() on each string
		for (String str : strArray)
			System.out.printf("hasUpperCase(%s) = %s\n",
					str, ac.hasUpperCase(str));
		System.out.println();
		
		// Test convertUpperCase() on each string
		for (String str : strArray)
			System.out.printf("convertUpperCase(%s) = %s\n",
					str, ac.convertUpperCase(str));
		System.out.println();
		
		// Test convertAddTen() on each string
		for (String str : strArray) {
			System.out.printf("convertAddTen(%s): ", str);
			ac.convertAddTen(str);
		}
	}

}
