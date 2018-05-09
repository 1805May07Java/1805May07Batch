/*
 * AlphaChild.java
 * Author: Cole Vikupitz
 * 
 * Exercise 18: A concrete class that inherits the abstract methods
 * from the parent class, and implements them.
 */

package com.revature.exercise18;

public class AlphaChild extends AlphaParent {

	/**
	 * Returns true/false depending on if the string 'str' contains any
	 * uppercase characters.
	 * 
	 * @param str - The string to check.
	 * @return True if 'str' contains uppercase characters, false otherwise.
	 */
	@Override
	public boolean hasUpperCase(String str) {
		
		for (char ch : str.toCharArray())
			// Character is uppercase, return true
			if (ch >= 65 && ch <= 90)
				return true;
		
		// Reached end of string with no uppercase letters, return false
		return false;
	}

	/**
	 * Returns a new string where all lowercase letters in 'str' are
	 * converted into uppercase letters.
	 * 
	 * @param str - The string to convert.
	 * @return A new string with all uppercase characters.
	 */
	@Override
	public String convertUpperCase(String str) {
		
		// Create a char array for the new string
		char newStr[] = new char[str.length()];
		for (int i = 0; i < str.length(); i++)
			// Copy each character into array, converting to uppercase as needed
			newStr[i] = Character.toUpperCase(str.charAt(i));
		
		// Create new string with array, return result
		return new String(newStr);
	}

	/**
	 * Converts all letters within the string 'str' into it's
	 * numeric value, adds 10, and prints the result out on the
	 * command line.
	 * 
	 * @param str - The string to scan.
	 */
	@Override
	public void convertAddTen(String str) {
		
		int sum = 0;
		// Acquire ASCII value, add to sum variable
		for (char ch : str.toCharArray())
			sum += ch;
		// Add 10, display the result
		sum += 10;
		System.out.printf("%d\n", sum);
	}

}
