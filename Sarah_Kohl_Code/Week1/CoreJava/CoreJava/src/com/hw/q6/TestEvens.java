package com.hw.q6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestEvens {

	@Test
	void testsmallEven() {
		assertEquals(true, Even.isEven(4));
	}
	
	@Test
	void testNegativeEven() {
		assertEquals(true, Even.isEven(-4));
	}
	
	@Test
	void testOdd() {
		assertEquals(false, Even.isEven(7));
	}
	@Test
	void testZero() {
		assertEquals(true, Even.isEven(0));
	}
	
	

}
