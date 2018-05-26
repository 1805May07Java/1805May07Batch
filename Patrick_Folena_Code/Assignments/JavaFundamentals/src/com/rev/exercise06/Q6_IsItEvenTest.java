package com.rev.exercise06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Q6_IsItEvenTest {

	static Q6_IsItEven main;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		main = new Q6_IsItEven();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		main = null;
	}
	
	@Test
	void testIsZeroEven() {
		assertEquals(true, main.isEven(0));
	}
	
	@Test
	void testNegativeEven() {
		assertEquals(true, main.isEven(-256));
		
		assertEquals(false, main.isEven(-123));
	}
	
	@Test
	void testPositiveEven() {
		assertEquals(true, main.isEven(256));
		
		assertEquals(false, main.isEven(123));
	}
	
	void testMultiplyFun() {
		assertEquals(true, main.isEven(64*2));
	}

}
