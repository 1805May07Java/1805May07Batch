/*
 * AccessDemo.java
 * Author: Cole Vikupitz
 * 
 * Exercise 11: Program that demonstrates accessing variables
 * from inside a class from a different package.
 */

package com.revature.exercise11;

// Imports
import com.revature.exercise11b.*;

public class AccessDemo {

	public static void main(String[] args) {
		
		// Create a new instance, access variables from the instance
		Car car = new Car("Green");
		System.out.printf("MPG: %.02f\n", car.mpg);
		System.out.printf("Speed: %.02f mph\n", car.speed);
		
		/*
		 * Cannot access any protected, default, or private class
		 * members directly without the use of getter methods.
		 * 
		 * Un-commenting the following lines will generate errors
		 * from an IDE or attempting to compile.
		 */
		//System.out.printf("Max Gallons: %f\n", car.maxGallons);
		//System.out.printf("Gas Left: %f\n", car.gallonsLeft);
		//System.out.printf("Color: %s\n", car.color);
		//System.out.printf("Year: %d\n", car.year);
	}
}
