package com.revhomework.Question17;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InterestTest {
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void testSimpleInterest() 
	{
		assertEquals(Interest.simpleInterest(2, 3, 2), 12);
		assertNotEquals(Interest.simpleInterest(12, .35, 7),100);
		assertEquals(Interest.simpleInterest(25, 5, 3), 375);
	}

}
