package com.rev.question6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EvenTest {
	Even e;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		e = new Even();
	}

	@AfterEach
	void tearDown() throws Exception {
		e = null;
	}

	@Test
	void test() {
		int even = 4;
		
		int odd = 127;
		
		assertEquals(e.even(even), true);
		assertEquals(e.even(odd), false);
	}

}
