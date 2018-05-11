package com.rev.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.rev.questions.BubbleSort;

class BubbleSortTest {

	@Test
	void testExample() {
		int[] a = {1,0,5,6,3,2,3,7,9,8,4};
		int[] b = a.clone();
		
		BubbleSort.bubbleSort(a);
		Arrays.sort(b);
		
		for (int i = 0; i < b.length; i++) {
			assertEquals(b[i], a[i], i+ "th element discrepency");
		}
	}

}
