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

	// Test Case 1
	@Test
	public void test1() {
		
		String str = "123456789";
		assertEquals(SubString.getSubString(str, 0), "1");
	}
	
	// Test Case 2
	@Test
	public void test2() {
		
		String str = "123456789";
		assertEquals(SubString.getSubString(str, 50), "123456789");
		
	}
	
	// Test Case 3
	@Test
	public void test3() {
		
		String str = "123456789";
		assertEquals(SubString.getSubString(str, 1), "12");
	}
	
	// Test Case 4
	@Test
	public void test4() {
		
		String str = "123456789";
		assertEquals(SubString.getSubString(str, 4), "12345");
	}
	
	// Test Case 5
	@Test
	public void test5() {

		String str = "123456789";
		assertEquals(SubString.getSubString(str, 8), "123456789");
	}

}
