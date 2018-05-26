package com.rev.exercise04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rev.exercise03.Q3_StringReversal;

class Q4_NFactorialTest {

	static Q4_NFactorial main;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		main = new Q4_NFactorial();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		main = null;
	}
	
	@Test
	void testNegativeFactorial()
	{
		long x = main.factorial(-20);
		assertEquals(-1, x);
	}
	
	@Test
	void testZeroFactorial() {
		long x = main.factorial(0);
		assertEquals(0, x);
	}
	
	@Test
	void testRandomFactorials() {
		long x = main.factorial(5);
		assertEquals(120, x);
		
		x = main.factorial(10);
		assertEquals(3628800, x);
		
		x = main.factorial(1);
		assertEquals(1, x);
		
	}

}
