package com.rev.exercise10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Q10_TernMinTest {

	static Q10_TernMin main;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		main = new Q10_TernMin();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		main = null;
	}

	@Test
	void basicTests() {
		assertEquals(3, main.minNum(3, 6));
		assertEquals(3, main.minNum(6, 3));
		assertEquals(3, main.minNum(3, 3));
	}
	
	void maxMin()
	{
		assertEquals(Integer.MIN_VALUE, main.minNum(Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

}
