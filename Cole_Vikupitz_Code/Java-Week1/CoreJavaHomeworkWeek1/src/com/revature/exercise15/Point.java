/*
 * Point.java
 * Author: Cole Vikupitz
 * 
 * Exercise 15: Class that represents a point on a 2D graph;
 * implements the Operable interface allowing points to be
 * added, subtracted, multiplied, and divided between each
 * other.
 */

package com.revature.exercise15;

public class Point implements Operable<Point> {
	
	private int x, y;
	
	public Point(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return String.format("(%d, %d)", x, y);
	}

	///////////////////////////////////////////////////////////////
	//  GETTERS AND SETTERS
	///////////////////////////////////////////////////////////////
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	//////////////////////////////////////////////////////////////
	//  END OF GETTERS AND SETTERS
	//////////////////////////////////////////////////////////////

	/**
	 * Adds this point and 'other' together, returns the new added
	 * Point instance.
	 * 
	 * @param other - The other point instance to add.
	 * @return The new added point.
	 */
	@Override
	public Point addition(Point other) {
		return new Point(this.x + other.x, this.y + other.y);
	}

	/**
	 * Subtracts this point from 'other', returns the new subtracted
	 * Point instance.
	 * 
	 * @param other - The other point instance to subtract.
	 * @return The new subtracted point.
	 */
	@Override
	public Point subtraction(Point other) {
		return new Point(this.x - other.x, this.y - other.y);
	}

	/**
	 * Multiplies this point and 'other' together, returns the new
	 * multiplied Point instance.
	 * 
	 * @param other - The other point instance to multiply.
	 * @return The new multiplied point.
	 */
	@Override
	public Point multiplication(Point other) {
		return new Point(this.x * other.x, this.y * other.y);
	}

	/**
	 * Divides this point by 'other', returns the new divided
	 * Point instance.
	 * 
	 * @param other - The other point instance to divide by.
	 * @return The new divided point.
	 */
	@Override
	public Point division(Point other) {
		return new Point(this.x / other.x, this.y / other.y);
	}
	
}
