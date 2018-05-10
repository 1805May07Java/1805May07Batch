/*
 * StringReverseTest.java
 * Author: Cole Vikupitz
 * 
 * JUnit test cases for the string reversing algorithm for exercise 3.
 */

package com.revature.exercise3;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringReverseTest {

	@Test
	public void test() {
		// Test Case 1
		assertEquals(StringReverse.reverseStr(""), "");
		
		// Test Case 2
		assertEquals(StringReverse.reverseStr("this"), "siht");
		
		// Test Case 3
		assertEquals(StringReverse.reverseStr("THIS"), "SIHT");
		
		// Test Case 4
		assertEquals(StringReverse.reverseStr("...TYPO,,,"), ",,,OPYT...");
		
		// Test Case 5
		assertEquals(StringReverse.reverseStr("This is a test."), ".tset a si sihT");
		
		// Test Case 6
		assertEquals(StringReverse.reverseStr("1234567890"), "0987654321");
		
		// Test Case 7
		assertEquals(StringReverse.reverseStr("!@#$%^&*()"), ")(*&^%$#@!");
	}

}
