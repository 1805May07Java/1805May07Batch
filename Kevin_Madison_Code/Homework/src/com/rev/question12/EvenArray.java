package com.rev.question12;

//Question 12: write a program to store number from 1 to 100 in an array print out all the even numbers from the array. use the enhaced for loop for printing out the numbers.
public class EvenArray {

	public static void main(String[] args) {
		int[] arr = new int[100];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		String rslt = printEven(arr);
		
		System.out.println(rslt);
	}
	
	public static String printEven(int[] arr) {
		String result = "";
		for(int i : arr) {
			int mod = i%2;
			if(mod == 0) {
				result += i + " ";
			}
		}
		return result;
	}

}
