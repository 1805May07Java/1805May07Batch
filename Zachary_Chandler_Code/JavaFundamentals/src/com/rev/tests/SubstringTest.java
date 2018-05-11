package com.rev.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.rev.questions.Substring;

class SubstringTest {

	@Test
	void testSubstring() {
		assertEquals(Substring.substring("Dog", 2), "Do");
		assertEquals(Substring.substring("Dog", 3), "Dog");
		assertEquals(Substring.substring("Films", 1), "F");
		assertEquals(Substring.substring("Nothing", 0), "");
	}

	@Test
	void testNegativeIndex() {
		assertThrows(IllegalArgumentException.class, () -> Substring.substring("Dog", -1));
	}
	
	@Test
	void testOutOfBoudsIndex() {
		assertThrows(IllegalArgumentException.class, () -> Substring.substring("Dog", 4));
	}

}
