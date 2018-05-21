/*
 * Operable.java
 * Author: Cole Vikupitz
 * 
 * Exercise 15: An interface that allows objects to implement
 * to add, subtract, multiply, and divide among one another.
 */

package com.revature.exercise15;

public interface Operable<T> {

	// Adds two objects together, return result
	public T addition(T other);
	
	// Subtracts two objects, return result
	public T subtraction(T other);
	
	// Multiplies two objects, return result
	public T multiplication(T other);
	
	// Divides two objects, return result
	public T division(T other);

}
