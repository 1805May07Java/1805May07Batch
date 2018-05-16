/*
 * Main.java
 * Author: Cole Vikupitz
 *
 * In class-based programming, the factory method pattern is a creational pattern
 * that uses factory methods to deal with the problem of creating objects without
 * having to specify the exact class of the object that will be created. This is
 * done by creating objects by calling a factory method—either specified in an
 * interface and implemented by child classes, or implemented in a base class and
 * optionally overridden by derived classes—rather than by calling a constructor.
 *
 * - from Wikipedia (https://en.wikipedia.org/wiki/Factory_method_pattern)
 */

package com.revature.factory;

public class Main {

	public static void main(String[] args) {

		// Create instances via factory method
		Shapeable s1 = ShapeFactory.getShape(ShapeFactory.SQUARE);
		Shapeable s2 = ShapeFactory.getShape(ShapeFactory.TRIANGLE);
		Shapeable s3 = ShapeFactory.getShape(ShapeFactory.CIRCLE);

		System.out.println(s1.shape());
		System.out.println(s2.shape());
		System.out.println(s3.shape());
	}
}
