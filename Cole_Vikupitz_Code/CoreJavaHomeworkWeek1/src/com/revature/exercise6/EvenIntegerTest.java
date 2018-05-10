/*
 * EvenIntegerTest.java
 * Author: Cole Vikupitz
 * 
 * JUnit test cases for the even number checking function for exercise 6.
 */

package com.revature.exercise6;

import static org.junit.Assert.*;

import org.junit.Test;

public class EvenIntegerTest {

	// Test Case 1
	@Test
	public void test1() {
		assertEquals(EvenInteger.isEven(0), true);
	}
	
	// Test Case 2
	@Test
	public void test2() {
		assertEquals(EvenInteger.isEven(1), false);
	}
	
	// Test Case 3
	@Test
	public void test3() {
		assertEquals(EvenInteger.isEven(4), true);
	}
	
	// Test Case 4
	@Test
	public void test4() {
		assertEquals(EvenInteger.isEven(5), false);
	}
	
	// Test Case 5
	@Test
	public void test5() {
		assertEquals(EvenInteger.isEven(9), false);
	}

}
