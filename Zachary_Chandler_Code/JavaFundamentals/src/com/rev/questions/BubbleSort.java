package com.rev.questions;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] a = {1,0,5,6,3,2,3,7,9,8,4};
		

		System.out.println(Arrays.toString(a));
		bubbleSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void bubbleSort(int[] a) {
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < a.length - i; j++) {
				if (a[j-1] > a[j]) {
					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
				}
			}
		}
	}
}
