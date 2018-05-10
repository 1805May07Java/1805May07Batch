/*
 * StringReverseTest.java
 * Author: Cole Vikupitz
 * 
 * JUnit test cases for the string reversing algorithm for exercise 3.
 */

package com.revature.exercise3;

// Imports
import static org.junit.Assert.*;

import org.junit.Test;

public class StringReverseTest {

	// Test Case 1
	@Test
	public void test1() {
		
		assertEquals(StringReverse.reverseStr(""), "");
	}
	
	// Test Case 2
	@Test
	public void test2() {
		
		assertEquals(StringReverse.reverseStr("this"), "siht");
	}
	
	// Test Case 3
	@Test
	public void test3() {
		
		assertEquals(StringReverse.reverseStr("THIS"), "SIHT");	
	}
	
	// Test Case 4
	@Test
	public void test4() {
		
		assertEquals(StringReverse.reverseStr("...TYPO,,,"), ",,,OPYT...");	
	}
	
	// Test Case 5
	@Test
	public void test5() {
		
		assertEquals(StringReverse.reverseStr("This is a test."), ".tset a si sihT");
	}
	
	// Test Case 6
	@Test
	public void test6() {
		
		assertEquals(StringReverse.reverseStr("1234567890"), "0987654321");
	}
	
	// Test Case 7
	@Test
	public void test7() {
		
		assertEquals(StringReverse.reverseStr("!@#$%^&*()"), ")(*&^%$#@!");
	}

}
