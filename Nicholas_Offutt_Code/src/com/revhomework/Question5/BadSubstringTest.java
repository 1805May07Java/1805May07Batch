package com.revhomework.Question5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BadSubstringTest {
	
	BadSubstring tester;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		tester = new BadSubstring();
	}

	@AfterEach
	void tearDown() throws Exception {
		tester = null;
	}

	@Test
	void testBadSubber() 
	{
		assertEquals(tester.badSubber("were", 1), "we");
		assertNotEquals(tester.badSubber("were", 2), "we");
		assertEquals(tester.badSubber("testing", 3), "test");
		
	}

}
