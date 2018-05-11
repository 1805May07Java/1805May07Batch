package com.rev.question10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TernaryOperatorsTest {
	TernaryOperators to;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		to = new TernaryOperators();
	}

	@AfterEach
	void tearDown() throws Exception {
		to = null;
	}

	@Test
	void test() {
		int x = 20;
		int y = 21;
		int expected = 20;
		
		int min = to.findMin(x, y);
		
		assertEquals(min, expected);
	}

}
