package com.rev.exercise08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Q8_PalindromeTest {

	static Q8_Palindrome main;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		main = new Q8_Palindrome();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		main = null;
	}

	@Test
	void testEmptyString() {
		assertTrue(main.isAPalindrome(""));
	}
	
	@Test
	void testIgnoreUpperCase() {
		assertTrue(main.isAPalindrome("UnDeREdNu"));
	}
	
	@Test
	void testSpaceAndNewLine() {
		assertTrue(main.isAPalindrome("Madam Im adam"));
		assertTrue(main.isAPalindrome("Madam \n Im Adam"));
	}
	
	@Test
	void testBasic() {
		assertTrue(main.isAPalindrome("madam"));
		assertTrue(main.isAPalindrome("oppo"));
		assertTrue(!main.isAPalindrome("word"));
		assertTrue(!main.isAPalindrome("Hippo"));
	}
}
