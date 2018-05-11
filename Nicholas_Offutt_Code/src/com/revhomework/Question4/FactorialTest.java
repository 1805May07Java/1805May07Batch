package com.revhomework.Question4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FactorialTest {
	Factorial test;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		test = new Factorial();
	}

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}

	@Test
	void testFactor() {
		//what to do with these void methods?
		test.factor(5);
		test.factor(8);
		
	}

}
