package com.rev.question4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FactorialTest {
	Factorial f;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		f = new Factorial();
	}

	@AfterEach
	void tearDown() throws Exception {
		f = null;
	}

	@Test
	void test() {
		int number = 5;
		int expected = 120;
		assertEquals(f.factorial(number), expected);
	}

}
