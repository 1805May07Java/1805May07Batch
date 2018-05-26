package com.rev.exercise01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Q1_BubbleSortTest {

	static Q1_BubbleSort main;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		main = new Q1_BubbleSort();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		main = null;
	}

	@Test
	void testBubbleSortNullInput() {
		int[] test = null;
		assertNull(main.bubbleSort(test));
	}
	
	@Test
	void testBubbleSortEmptySet() {
		int[] test = {};
		int[] expected = {};
		assertArrayEquals(main.bubbleSort(test), expected);
	}
	
	@Test
	void testBubbleSortOneNumber() {
		int[] test = {1};
		int[] expected = {1};
		assertArrayEquals(main.bubbleSort(test), expected);
	}

	@Test
	void testBubbleSortSameSet() {
		int[] test = {2, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] expected = {1,1,1,1,1,1,1,1,2};
		assertArrayEquals(main.bubbleSort(test), expected);
	}
	
	@Test
	void testBasicSortSet() {
		int[] test = {1,0,5,6,3,2,3,7,9,8,4};
		int[] expected = {0,1,2,3,3,4,5,6,7,8,9}; 
		assertArrayEquals(main.bubbleSort(test), expected);
	}

	@Test
	void testBubbleSortExtremeSet() {
		int[] test = new int[1000];
		int[] expected = new int[1000];
		
		for(int x = 0; x < 1000; x++)
		{
			test[x] = 999-x;
			expected[x] = x;
		}
		
		assertArrayEquals(main.bubbleSort(test), expected);
	}
}
