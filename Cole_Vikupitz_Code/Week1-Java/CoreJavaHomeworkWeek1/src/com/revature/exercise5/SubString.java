/*
 * SubString.java
 * Author: Cole Vikupitz
 * 
 * Exercise 5: Program that implements a substring method that
 * creates and returns a substring of another given an index, which
 * includes all characters from index 0 to the index (inclusive).
 */

package com.revature.exercise5;

public class SubString {

	/**
	 * Creates and returns a substring of 'str' contained within
	 * index 0 to 'idx' inclusive. If 'idx' is larger than the size
	 * of 'str', a new copy of 'str' is returned.
	 * 
	 * @param str - The string to get a substring of.
	 * @param idx - The index in 'str' to copy up to (inclusive).
	 * @return The resulting substring of 'str'.
	 */
	public static String getSubString(String str, int idx) {
		
		// 'idx' is larger than the string, return a new copy
		if (idx >= str.length())
			return new String(str);

		// Create new char array for substring
		char[] subStr = new char[idx + 1];
		// Loop through 'str', copy up to 'idx' characters
		for (int i = 0; i <= idx && i < str.length(); i++)
			subStr[i] = str.charAt(i);

		// Create new string from char array, return result
		return new String(subStr);
	}
	
	public static void main(String[] args) {

		// String to test substring method on
		String abc = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i <= abc.length() + 1; i++)
			// Test method on string, display result
			// Make sure that cases where idx > length() works as well
			System.out.printf("getSubString(\"%s\", %d) = \"%s\"\n",
					abc, i, getSubString(abc, i));
	}

}
