package com.rev.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.rev.questions.CharacterCount;

class CharacterCountTest {

	@Test
	void testCount() {
		assertEquals(CharacterCount.count("hello world"), "hello world".length());
		assertEquals(CharacterCount.count(""), 0);
	}
	
	@Test
	void testNullCount() {
		assertThrows(NullPointerException.class, () -> CharacterCount.count(null));
	}

}
