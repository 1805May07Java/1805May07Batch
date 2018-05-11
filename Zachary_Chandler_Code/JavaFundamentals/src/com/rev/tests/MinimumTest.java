package com.rev.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.rev.questions.Minimum;

class MinimumTest {

	@Test
	void testFirstSmaller() {
		assertEquals(Minimum.min(1, 3), 1);
	}

	@Test
	void testSecondSmaller() {
		assertEquals(Minimum.min(5, 3), 3);
	}

	@Test
	void testEquals() {
		assertEquals(Minimum.min(6, 6), 6);
	}
	
	@Test
	void testNegatives() {
		assertEquals(Minimum.min(-1, -2), -2);
		assertEquals(Minimum.min(-1, 3), -1);
	}

}
