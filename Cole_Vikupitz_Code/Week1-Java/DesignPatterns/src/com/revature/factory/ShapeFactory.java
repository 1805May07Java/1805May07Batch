/*
 * ShapeFactory.java
 * Author: Cole Vikupitz
 *
 * Contains factory method for generating instances of Shapeable.
 */

package com.revature.factory;

public class ShapeFactory {

	// Types of shapeable objects to return
	public static final int SQUARE = 1;
	public static final int TRIANGLE = 2;
	public static final int CIRCLE = 3;

	public static Shapeable getShape(int shape) {

		switch(shape) {
			case SQUARE:  // Return a shapeable square
				return new Square();
			case TRIANGLE:  // Return a shapeable triangle
				return new Triangle();
			case CIRCLE:  // Return a shapeable circle
				return new Circle();
			default:  // Invalid code, return null
				return null;
		}
	}
}
