package com.hw.q10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMin {

	@Test
	void test() {
		assertEquals(1, Min.min(5, 1), "One is less than five.");
		assertEquals(1, Min.min(1, 5), "One is less than five (inverted).");
		assertEquals(-1, Min.min(-1, 1), "Negative one is less than one.");
		assertEquals(-10, Min.min(-1, -10), "Negative 10 is less than negative one");		
	}

}
