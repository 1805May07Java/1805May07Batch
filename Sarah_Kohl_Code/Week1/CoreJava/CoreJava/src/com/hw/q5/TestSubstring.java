package com.hw.q5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TestSubstring {

	@Test
	void test() {
		assertEquals("hello w", SubString.getSubStringFromZeroTo("hello world", 7));
	}

	@Test
	void testException() {
			assertThrows(IndexOutOfBoundsException.class, () -> SubString.getSubStringFromZeroTo("Hello",-1));
	}
	
}
