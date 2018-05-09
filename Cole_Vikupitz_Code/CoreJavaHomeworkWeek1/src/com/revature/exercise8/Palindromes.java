/*
 * Palindromes.java
 * Author: Cole Vikupitz
 * 
 * Exercise 8: Program that checks whether a string is a palindrome.
 */

package com.revature.exercise8;

// Imports
import java.util.ArrayList;

public class Palindromes {
	
	/**
	 * Returns true/false whether the string 'str' is a palindrome or not.
	 * 
	 * @param str - The string to check.
	 * @return True if 'str' is a palindrome, false otherwise.
	 */
	public static boolean isPalindrome(String str) {
		
		int len = str.length();
		// Retrieve 2 characters from opposite ends of the string
		// Compare the 2 characters; if unequal, string cannot be a palindrome
		// If we iterate all the way through, string is a palindrome
		for (int i = 0, j = len-1; i <= len/2; i++, j--) {
			char a = str.charAt(i);
			char b = str.charAt(j);
			// The characters are unequal, return false
			if (a != b)
				return false;
		}
		
		// At this point, the string must be a palindrome, so return true
		return true;
	}

	public static void main(String[] args) {
		
		// Create & populate array list with strings
		ArrayList<String> stringList = new ArrayList<String>();
		stringList.add("karan");
		stringList.add("madam");
		stringList.add("tom");
		stringList.add("civic");
		stringList.add("radar");
		stringList.add("sexes");
		stringList.add("jimmy");
		stringList.add("kayak");
		stringList.add("john");
		stringList.add("refer");
		stringList.add("billy");
		stringList.add("did");
		
		// Print out strings in the array list
		System.out.println("The array list of strings:");
		for (String str : stringList)
			System.out.println(str);
		
		// Create new array list to store the palindromes
		ArrayList<String> palindromes = new ArrayList<String>();
		// Add each of the palindromes into the new array list
		for (String str : stringList)
			if (isPalindrome(str))
				palindromes.add(str);
		
		// Print out all the palindromes in the array list
		System.out.println("\nThe array list of palindromes:");
		for (String str : palindromes)
			System.out.println(str);
	}

}
