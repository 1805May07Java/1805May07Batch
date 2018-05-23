package com.rev.questions;

public class Exc1_Bubble {
//Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4

	public int[] bubble(int[] array) {
		int holder;
		
		for(int i = 0; i < array.length; i++) {System.out.print(array[i]);}
		int i = 0;
		
		do {
			if(array[i] > array[i+1]) {
				holder = array[i];
				array[i] = array[i+1];
				array[i+1] = holder;
				i = 0;
			}
			else {i++;};
			
		}while(i < array.length -1);
		
		return array;
		
		
	}
}
