package com.rev.exercise09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Q9_PrimeTest {

	static Q9_Prime main;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		main = new Q9_Prime();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		main = null;
	}

	@Test
	void testZero() {
		assertTrue(!main.isAPrime(0));
	}
	
	@Test
	void testOne() {
		assertTrue(!main.isAPrime(1));
	}
	
	@Test
	void testNeg() {
		assertTrue(!main.isAPrime(-20));
	}
	
	@Test
	void testBasic() {
		assertTrue(!main.isAPrime(91));
		assertTrue(main.isAPrime(3));
	}
	
	void testExtreme() {
		assertTrue(main.isAPrime(15485863));
		assertTrue(!main.isAPrime(15485861));
	}

}
