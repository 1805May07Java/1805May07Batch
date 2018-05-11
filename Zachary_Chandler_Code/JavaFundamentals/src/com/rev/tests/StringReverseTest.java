package com.rev.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.rev.questions.StringReverse;

class StringReverseTest {

	@Test
	void testNonPalindrome() {
		assertEquals(StringReverse.reverseString("Father"), "rehtaF");
	}

	@Test
	void testPalindrome() {
		assertEquals(StringReverse.reverseString("neven"), "neven");
	}
	
	@Test
	void testEmptyString() {
		assertEquals(StringReverse.reverseString(""), "");
	}

}
