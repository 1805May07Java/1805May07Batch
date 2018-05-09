/*
 * StringReverse.java
 * Author: Cole Vikupitz
 * 
 * Exercise 3: Program that reverses and returns a given string.
 */

package com.revature.exercise3;

public class StringReverse {
	
	/*
	 * Returns a reversed version of 'str'.
	 * 
	 * @param str - The string to reverse.
	 * @return The reversed string 'str'.
	 */
	public static String reverseStr(String str) {
		
		// Create new char array to store reversed result
		int len = str.length();
		char[] reversed = new char[len];
		// Iterate through the string backwards
		// Populate the array in reverse order
		for (int i = 0, j = len - 1; j >= 0; i++, j--)
			reversed[i] = str.charAt(j);
		
		// Create new string from char array, return result
		return new String(reversed);
	}

	public static void main(String[] args) {
		
		// Test a variety of strings to reverse
		System.out.printf("\"%s\" reversed: \"%s\"\n", "This", reverseStr("This"));
		System.out.printf("\"%s\" reversed: \"%s\"\n", "is", reverseStr("is"));
		System.out.printf("\"%s\" reversed: \"%s\"\n", "a", reverseStr("a"));
		System.out.printf("\"%s\" reversed: \"%s\"\n", "Test.", reverseStr("Test."));
		System.out.printf("\"%s\" reversed: \"%s\"\n", "", reverseStr(""));
		System.out.printf("\"%s\" reversed: \"%s\"\n",
				"abcdefghijklmnopqrstuvwxyz",
				reverseStr("abcdefghijklmnopqrstuvwxyz"));
	}
}
