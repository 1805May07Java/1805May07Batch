/*
 * BubbleSort.java
 * Author: Cole Vikupitz
 * 
 * Exercise 1: Program that performs a bubble sort on a given
 * integer array and returns the sorted array.
 */

package com.revature.exercise1;

public class BubbleSort {
	
	/**
	 * Performs a bubble sort on the integer array 'array',
	 * returns the sorted array.
	 * 
	 * @param array - The integer array to sort.
	 * @return The sorted integer array.
	 */
	public static int[] bubbleSort(int[] array) {
		
		int prev, next;
		
		// For arrays with one/no element, just return
		if (array.length <= 1)
			return array;
		
		// Iterate through the array
		int len = array.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				// Jump to the next two elements
				prev = array[j];
				next = array[j + 1];
				// If the next element is greater than the previous,
				// we need to swap them in place
				if (next < prev) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}

		// Return the sorted array
		return array;
	}
	
	public static void main(String[] args) {
		
		// Initialize the unsorted integer array
		int[] theArray = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		// Print the unsorted array
		System.out.print("The array before:");
		for (int i : theArray)
			System.out.printf(" %d", i);

		// Perform the bubble sort, get sorted array
		int[] sortedArray = bubbleSort(theArray);
		System.out.println("\nSorted the array with bubble sort.");
		// Print the sorted array
		System.out.print("The array after:");
		for (int i : sortedArray)
			System.out.printf(" %d", i);
		System.out.println();
		
	}

}
