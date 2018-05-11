package com.rev.evenarray;

public class Even_Array {
	
	public static void main(String []args) {
		System.out.println("Even Numbers in the Array");
		int [] array = new int[100];
		//Loop through array, adding a number each pass up to 100
		for (int a = 1; a < array.length+1; a++) {
		    array[a - 1] = a;
		}
		//Loop through array, checking for evens, then print them to console
		for(int b : array){
	    	if(b % 2 == 0) {
	    	System.out.print(b + " ,");	
	    	}
	    }
}
}
	//public static int [] getEven(int[] array) {
		
	//}