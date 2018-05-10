/*
 * SubStringTest.java
 * Author: Cole Vikupitz
 * 
 * JUnit test cases for the substring algorithm for exercise 5.
 */

package com.revature.exercise5;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubStringTest {

	@Test
	public void test() {
		
		String str = "123456789";
		// Test Case 1
		assertEquals(SubString.getSubString(str, 0), "1");
		// Test Case 2
		assertEquals(SubString.getSubString(str, 50), "123456789");
		// Test Case 3
		assertEquals(SubString.getSubString(str, 1), "12");
		// Test Case 4
		assertEquals(SubString.getSubString(str, 4), "12345");
		// Test Case 5
		assertEquals(SubString.getSubString(str, 8), "123456789");
	}

}
