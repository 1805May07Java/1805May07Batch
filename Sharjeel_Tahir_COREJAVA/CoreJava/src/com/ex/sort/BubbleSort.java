package com.ex.sort;

import java.util.Arrays;

public class BubbleSort {
	
	
	public static int[] bubbleSort (int[] list) {
		
		int i, j, temp = 0;
		for (i = 0; i < list.length - 1; i++) {
			for (j=0; j<list.length - 1 -i; j++) {
				if (list[j] > list[j+1]) {
					temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;					
				}
			}
		}
		
		return list;
	}
	

	public static void main(String[] args) {
		
		int[] arr1 = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int[] arr2 = bubbleSort(arr1);
		System.out.println(Arrays.toString(arr2));

	}

}
