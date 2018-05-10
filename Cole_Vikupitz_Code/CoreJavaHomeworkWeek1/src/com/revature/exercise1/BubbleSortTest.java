/*
 * BubbleSortTest.java
 * Author: Cole Vikupitz
 * 
 * JUnit test cases for the bubble sorting algorithm for exercise 1.
 */

package com.revature.exercise1;

import static org.junit.Assert.*;

import org.junit.Test;

public class BubbleSortTest {

	// Test Case 1
	@Test
	public void test1() {
		
		int[] arr1 = {1};
		int[] arr1Sort = {1};
		assertArrayEquals(BubbleSort.bubbleSort(arr1), arr1Sort);
	}
	
	// Test Case 2
	@Test
	public void test2() {
		
		int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] arr2Sort = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		assertArrayEquals(BubbleSort.bubbleSort(arr2), arr2Sort);
	}
	
	// Test Case 3
	@Test
	public void test3() {
		
		int[] arr3 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] arr3Sort = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		assertArrayEquals(BubbleSort.bubbleSort(arr3), arr3Sort);
	}
	
	// Test Case 4
	@Test
	public void test4() {
		
		int[] arr4 = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int[] arr4Sort = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		assertArrayEquals(BubbleSort.bubbleSort(arr4), arr4Sort);
	}

}
