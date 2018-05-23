package com.rev.excersizes;

//import java.util.Arrays;

public class UnderstandingArrays {
	public static void main(String[] args) {
		int [] arr = new int[5];
		arr[0] = 1;
		try {
			arr[10] = 19;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("in finally block");
		}
		int [] arr2 = {5, 7, 2, 8, 134};
		//int [] //;
		
		//int [][] twoD = new int[3][4];
		//Arrays.sort(arr2);
		
		for (int i : arr2) {
			System.out.println(i);
		}
		
		System.out.println(add(3, 4, 564, 3, 534));
		
	}
	
	static int add(int... nums) {
		int sum = 0;
		for(int n : nums) {
			sum += n;
		}
		
		return sum;
	}
}
