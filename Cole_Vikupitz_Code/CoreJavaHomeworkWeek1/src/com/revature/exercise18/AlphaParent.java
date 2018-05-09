/*
 * AlphaParent.java
 * Author: Cole Vikupitz
 * 
 * Exercise 18: A class containing a collection of abstract methods to be
 * implemented by some child class.
 */


package com.revature.exercise18;

public abstract class AlphaParent {

	/**
	 * Returns true/false depending on if the string 'str' contains any
	 * uppercase characters.
	 * 
	 * @param str - The string to check.
	 * @return True if 'str' contains uppercase characters, false otherwise.
	 */
	public abstract boolean hasUpperCase(String str);
	
	/**
	 * Returns a new string where all lowercase letters in 'str' are
	 * converted into uppercase letters.
	 * 
	 * @param str - The string to convert.
	 * @return A new string with all uppercase characters.
	 */
	public abstract String convertUpperCase(String str);
	
	/**
	 * Converts all letters within the string 'str' into it's
	 * numeric value, adds 10, and prints the result out on the
	 * command line.
	 * 
	 * @param str - The string to scan.
	 */
	public abstract void convertAddTen(String str);

}
