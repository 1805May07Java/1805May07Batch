package com.rev.exercises;

public class Fibonacci {

	public void fib() {
		
		int[] fibNums = new int [25];			//Create empty array of 25 elements
		fibNums[0] = 0;							//Initialize first two numbers of sequence
		fibNums[1] = 1;
		System.out.println(fibNums[0]);			//and print.
		System.out.println(fibNums[1]);
		for (int i = 2; i < fibNums.length; i++) {			//Iterate through elements of array starting from index 2
			fibNums[i] = fibNums[i-2] + fibNums[i-1];		//Assign element with the sum of 2 previous elements
			System.out.println(fibNums[i]);					//and print.
		}
	}
	
	/*public int fib(int in) {
		return in;
	}*/
	
}
