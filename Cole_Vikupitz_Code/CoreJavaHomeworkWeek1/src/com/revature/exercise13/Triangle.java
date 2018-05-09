/*
 * Triangle.java
 * Author: Cole Vikupitz
 *
 * Exercise 13: Program that prints a right triangle on the command prompt
 * given its height.
 */

package com.revature.exercise13;

public class Triangle {
	
	public static void displayRightTriangle(int height) {
		
		// Boolean variable that alternates
		// Determines if '0' or '1' is printed
		boolean isZero = true;
		
		// Two loops needed:
		// The outer loop runs 'height' times
		// The inner loop used to build each row of triangle
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= i; j++) {
				// Prints out a '0' or a '1', alternates the variable
				System.out.printf("%s ", isZero ? "0" : "1");
				isZero = !isZero;
			}
			// Print a new line for next row in triangle
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		// Prints a right triangle, given a height
		final int HEIGHT = 4;
		displayRightTriangle(HEIGHT);
	}
}
