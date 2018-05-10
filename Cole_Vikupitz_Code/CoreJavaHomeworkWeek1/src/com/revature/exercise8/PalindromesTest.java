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

	@Test
	public void test() {
		
		// Test Case 1
		assertEquals(Palindromes.isPalindrome("karan"), false);
		// Test Case 2
		assertEquals(Palindromes.isPalindrome("madam"), true);
		// Test Case 3
		assertEquals(Palindromes.isPalindrome("tom"), false);
		// Test Case 4
		assertEquals(Palindromes.isPalindrome("civic"), true);
		// Test Case 5
		assertEquals(Palindromes.isPalindrome("radar"), true);
		// Test Case 6
		assertEquals(Palindromes.isPalindrome("sexes"), true);
		// Test Case 7
		assertEquals(Palindromes.isPalindrome("jimmy"), false);
		// Test Case 8
		assertEquals(Palindromes.isPalindrome("kayak"), true);
		// Test Case 9
		assertEquals(Palindromes.isPalindrome("john"), false);
		// Test Case 10
		assertEquals(Palindromes.isPalindrome("refer"), true);
		// Test Case 11
		assertEquals(Palindromes.isPalindrome("billy"), false);
		// Test Case 12
		assertEquals(Palindromes.isPalindrome("did"), true);
		// Test Case 13
		assertEquals(Palindromes.isPalindrome(""), true);
	}

}
