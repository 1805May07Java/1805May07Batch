/*
 * ArrayOfOneHundred.java
 * Author: Cole Vikupitz
 * 
 * Exercise 12: Program that populates an array with integers 1-100.
 * Prints out all numbers in the array, then all the even numbers using
 * the enhanced FOR loop.
 */

package com.revature.exercise12;

public class ArrayOfOneHundred {

	public static void main(String[] args) {
		
		// Create & populate the array with numbers 1-100
		int array[] = new int[100];
		for (int i = 0; i < array.length; i++)
			array[i] = (i + 1);
		
		// Print out all numbers in the array
		System.out.println("Populated the array with numbers 1 - 100:");
		for (int i : array)
			System.out.printf("%d ", i);
		System.out.println();
		
		// Prints out only the even numbers
		System.out.println("Printing out all even items:");
		for (int i : array)
			if (i % 2 == 0)
				System.out.printf("%d ", i);
		System.out.println();
	}
}
