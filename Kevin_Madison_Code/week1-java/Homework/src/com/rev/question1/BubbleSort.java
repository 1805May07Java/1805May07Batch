package com.rev.question1;


//Question1: Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
public class BubbleSort {
	
	
	
	public static void main(String[] args) {
		//initialize variables
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		
		System.out.println("Array before sorting: ");
		for(int i = 0; i< arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(',');
		}
		
		arr = sort(arr);
		
		System.out.println("\n Array after sorting: ");
		for(int i = 0; i< arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(',');
		}
	}
	
	public static int[] sort(int[] tempArr) {
		int index = 0;
		while(index < tempArr.length-1) {
			for(int i = index+1; i <tempArr.length ; i++) {
				int x = tempArr[index];
				int y = tempArr[i];
				
				if(x > y) {
					tempArr[index] = y;
					tempArr[i] = x;
					index = 0;
					break;
				}else {
					index++;
				}
				
			}
		}
		
		return tempArr;
	}
}
