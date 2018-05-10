/*
 * FactorialTest.java
 * Author: Cole Vikupitz
 * 
 * JUnit test cases for the factorial algorithm for exercise 4.
 */

package com.revature.exercise4;

// Imports
import static org.junit.Assert.*;

import org.junit.Test;

public class FactorialTest {

	@Test
	public void test() {
		long[] expected = {1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 362880L, 3628800L};
		for (int i = 0; i < expected.length; i++)
			assertEquals(Factorial.factorial(i), expected[i]);
	}

}
