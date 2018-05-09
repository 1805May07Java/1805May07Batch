package com.rev.bubble;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[]args) {
		int[] numbers = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println("unsorted: " + Arrays.toString(numbers));
		bubbleSort(numbers);
		System.out.println("sorted: " + Arrays.toString(numbers));
	}
	
    public static void swap(int[] array, int from, int to){
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
	
    public static void bubbleSort(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers.length -1; j > i; j--) {
                if (numbers[j] < numbers[j - 1]) {
                    swap(numbers, j, j-1);
                }
            }
        }
    }
}
