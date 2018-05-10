package com.rev.question1;


//Question1: Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
public class BubbleSort {
	
	
	
	public static void main(String[] args) {
		//initialize variables
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		int index = 0;
		
		for(int i = 0; i< arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(',');
		}
		
		
		while(index < arr.length-1) {
			for(int i = index+1; i <arr.length ; i++) {
				int x = arr[index];
				int y = arr[i];
				
				if(x > y) {
					arr[index] = y;
					arr[i] = x;
					index = 0;
					break;
				}else {
					index++;
				}
				
			}
		}
		
		System.out.println("\n");
		for(int i = 0; i< arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(',');
		}
		
		
	}
	
}
