package com.rev.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.rev.questions.Factorial;

class FactorialTest {

	@Test
	void testFiveFactorial() {
		assertEquals(Factorial.factorial(5), 24 * 5);
	}

	@Test
	void testOneFactorial() {
		assertEquals(Factorial.factorial(1), 1);
	}

	@Test
	void testZeroFactorial() {
		assertEquals(Factorial.factorial(0), 1);
	}
	
	@Test
	void testNegativeFactorial() {
		assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
	}

}
