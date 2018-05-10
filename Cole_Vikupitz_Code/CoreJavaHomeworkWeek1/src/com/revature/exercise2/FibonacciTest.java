/*
 * FibonacciTest.java
 * Author: Cole Vikupitz
 * 
 * JUnit test cases for the fibonacci sequence algorithm for exercise 2.
 */

package com.revature.exercise2;

// Imports
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FibonacciTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After method");
	}

	@Test
	public void test() {
		System.out.println("IN TEST METHOD");
		long[] expected = {0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L, 144L, 233L, 377L};
		for (int i = 0; i < expected.length; i++)
			assertEquals(Fibonacci.fibonacciSequence(i), expected[i]);
	}
}
