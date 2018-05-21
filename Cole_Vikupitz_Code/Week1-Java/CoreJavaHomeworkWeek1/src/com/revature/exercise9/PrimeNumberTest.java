/*
 * PrimeNumberTest.java
 * Author: Cole Vikupitz
 * 
 * JUnit test cases for the prime number function for exercise 9.
 */

package com.revature.exercise9;

// Imports
import static org.junit.Assert.*;

import org.junit.Test;

public class PrimeNumberTest {

	@Test
	public void test() {
		
		boolean[] expected = {false, true, true, false, true, false, true, false, false, false};
		for (int i = 0; i < expected.length; i++)
			assertEquals(PrimeNumberPrinter.isPrime(i + 1), expected[i]);
	}

}
