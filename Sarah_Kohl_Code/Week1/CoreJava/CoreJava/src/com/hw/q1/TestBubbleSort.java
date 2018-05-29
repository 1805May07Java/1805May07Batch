package com.hw.q1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBubbleSort {

	@Test
	void testSort() {
		BubbleSort tester = new BubbleSort();
		
		Integer[] testArray = new Integer[] {1,0,5,6,3,2,3,7,9,8,4};
		
		BubbleSort.sort(testArray);
		
		assertArrayEquals( new Integer[] {0,1,2,3,3,4,5,6,7,8,9}, testArray);
	}

}
