/*
 * PointDemo.java
 * Author: Cole Vikupitz
 * 
 * Exercise 15: Demonstrates the Point class that implements
 * the Operable interface described in the exercise.
 */

package com.revature.exercise15;

public class PointDemo {

	public static void main(String[] args) {
		
		// Create 2 points to operate on
		Point p1 = new Point(9, 5);
		Point p2 = new Point(2, 4);
		
		// Test addition() on the points
		System.out.printf("%s + %s = %s\n", p1, p2, p1.addition(p2));
		// Test subtraction() on the points
		System.out.printf("%s - %s = %s\n", p1, p2, p1.subtraction(p2));
		// Test multiplication() on the points
		System.out.printf("%s * %s = %s\n", p1, p2, p1.multiplication(p2));
		// Test division() on the points
		System.out.printf("%s / %s = %s\n", p1, p2, p1.division(p2));
	}
}
