/**
 * ArgsCount.java
 * Author: Cole Vikupitz
 * 
 * Exercise 16: Displays the number of characters in a string for
 * each string passed as an argument.
 */

package com.revature.exercise16;

public class ArgsCount {

	public static void main(String[] args) {
		
		for (int i = 0; i < args.length; i++)
			// Displays the index, argument itself, and the number of characters
			System.out.printf("args[%d]: %s | Number of characters: %d\n",
					i, args[i], args[i].length());
	}
}
