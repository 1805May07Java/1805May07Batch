package com.ex.datatypes;

import java.util.Arrays;

public class UnderstandingArrays {
<<<<<<< HEAD
	/*An array is a group of variables
	 * Elements of an array must be same type
	 * the first element is at 0 index
	 * find array size by arrayName.length
	 */
	
	public static void main(String[] args) {
		int[] arr = new int[5];
		arr[0] =1;
		
		try {
			arr[10] =19;					//index out of bounds exception
=======
	/* An array is a group of variables
	 * Elements of an array must be the same type
	 * elements are accessed by an index
	 * the first element is at the 0th index
	 * find an array's size with arrayName.length
	 */
	public static void main(String[] args) {
		int[] arr = new int[5];
		arr[0] = 1;
		try {
			arr[10] = 19;
>>>>>>> 78273c64c95519911922bed60d38f95ba1129e8b
		}
		catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		finally {
<<<<<<< HEAD
			System.out.println("IN FINALLY BLOCK");
		}
			
		int[] arr2 = {5, 7, 2, 8, 134};
		
		int[][] twoD = new int[3][5];	//2D array
		
		for(int i: arr2) {
		System.out.print(i);
		}
		
	}
=======
			System.out.println("in finally block");
		}

		//int[] arr2 = new int[];
		int[] arr2 = {5, 7, 2, 8, 134};

		int[][] twoD = new int[3][4];

		//Arrays class -- java.util.Arrays
				/*
				 * There are often times when we need to do tasks on an array such as
				 * fill it with a value, sort, do a binary search, etc
				 */
		Arrays.sort(arr2);

		for(int i : arr2) {
			System.out.println(i);
		}
		
		System.out.println(add(3, 4, 564, 3,534 ));
		
	}
	
	//Var args
	static int add(int... nums) {
		int sum = 0;
		for(int n : nums) {
			sum += n; // sum = sum + n;
		}
		
		return sum;
	}

>>>>>>> 78273c64c95519911922bed60d38f95ba1129e8b
}
