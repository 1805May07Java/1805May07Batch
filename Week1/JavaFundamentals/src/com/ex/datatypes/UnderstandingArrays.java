package com.ex.datatypes;

import java.util.Arrays;

public class UnderstandingArrays {
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
		}
		catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("IN FINALLY BLOCK");
		}
			
		int[] arr2 = {5, 7, 2, 8, 134};
		
		int[][] twoD = new int[3][5];	//2D array
		
		for(int i: arr2) {
		System.out.print(i);
		}
		
	}
}
