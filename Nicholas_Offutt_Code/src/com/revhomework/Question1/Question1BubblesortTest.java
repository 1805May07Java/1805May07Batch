package com.revhomework.Question1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Question1BubblesortTest {
	
	int[] test1;
	int[] test2;
	int[] quesOne;
	int[] quesTwo;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception 
	{
		
	
		
	}

	@AfterEach
	void tearDown() throws Exception {
	
	}

	@Test
	void testSort() 
	{
		
		
		test1 = new int[] {5, 6, 2, 4, 1, 8};
		test2 = new int[] {1,2,7,3,1,9};
		quesOne = new int[] {1, 2, 4, 5, 6, 8};
		quesTwo = new int[] {1, 1, 2, 3, 7, 9};
		
		Question1Bubblesort.sort(test1);
		Question1Bubblesort.sort(test2);
		
		
		for(int i =0; i < test1.length; i++) 
		{
		assertEquals(test1[i], quesOne[i]);
		}
		
		for(int i =0; i < test2.length; i++) 
		{
		assertEquals(test2[i], quesTwo[i]);
		}
		
	}

}
