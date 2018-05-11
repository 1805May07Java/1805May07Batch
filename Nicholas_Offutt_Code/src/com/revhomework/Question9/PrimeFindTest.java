package com.revhomework.Question9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrimeFindTest {

	
	
	
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
	void testIsPrime() 
	{
		assertEquals(PrimeFind.isPrime(7), true);
		assertEquals(PrimeFind.isPrime(8), false);
		assertNotEquals(PrimeFind.isPrime(2), false);
	}

}
