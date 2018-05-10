/*
 * PalindromesTest.java
 * Author: Cole Vikupitz
 * 
 * JUnit test cases for the palindrome function for exercise 8.
 */

package com.revature.exercise8;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromesTest {

	// Test Case 1
	@Test
	public void test1() {
		assertEquals(Palindromes.isPalindrome("karan"), false);
	}
	
	// Test Case 2
	@Test
	public void test2() {
		assertEquals(Palindromes.isPalindrome("madam"), true);
	}
	
	// Test Case 3
	@Test
	public void test3() {
		assertEquals(Palindromes.isPalindrome("tom"), false);
	}
	
	// Test Case 4
	@Test
	public void test4() {
		assertEquals(Palindromes.isPalindrome("civic"), true);
	}
	
	// Test Case 5
	@Test
	public void test5() {
		assertEquals(Palindromes.isPalindrome("radar"), true);
	}
	
	// Test Case 6
	@Test
	public void test6() {
		assertEquals(Palindromes.isPalindrome("sexes"), true);
	}
	
	// Test Case 7
	@Test
	public void test7() {
		assertEquals(Palindromes.isPalindrome("jimmy"), false);
	}
	
	// Test Case 8
	@Test
	public void test8() {
		assertEquals(Palindromes.isPalindrome("kayak"), true);
	}
	
	// Test Case 9
	@Test
	public void test9() {
		assertEquals(Palindromes.isPalindrome("john"), false);
	}
	
	// Test Case 10
	@Test
	public void test10() {
		assertEquals(Palindromes.isPalindrome("refer"), true);
	}
	
	// Test Case 11
	@Test
	public void test11() {
		assertEquals(Palindromes.isPalindrome("billy"), false);
	}
	
	// Test Case 12
	@Test
	public void test12() {
		assertEquals(Palindromes.isPalindrome("did"), true);
	}
	
	// Test Case 13
	@Test
	public void test13() {
		assertEquals(Palindromes.isPalindrome(""), true);
	}

}
