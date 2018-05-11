package com.revhomework.Question12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Q12PrintEvenTest {

	
	int[] test1;
	int[] test2;
	
	
	
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
	void testPrintEven() 
	{
		
		test1 = new int[] {5, 6, 2, 4, 1, 8};
		test2 = new int[] {1,2,7,3,1,9};
		
		Q12PrintEven.printEven(test1);
		Q12PrintEven.printEven(test2);
		
		
		
	}

}
