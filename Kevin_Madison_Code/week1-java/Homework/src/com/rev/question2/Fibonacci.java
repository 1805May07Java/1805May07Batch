package com.rev.question2;
//Question 2: Write a program to display the first 25 Fibonacci numbers beginning at 0. 
public class Fibonacci {

	public static void main(String[] args) {
		System.out.println("The following is the first 25 fibonacci numbers beginning at 0:");
		
		int[] fib = new int[25];
		
		populateFibNumbers(fib);
		
		for(int i : fib) {
			System.out.print(i);
			System.out.print(",");
		}
	}
	
	public static int[] populateFibNumbers(int[] arry) {
		
		for(int i = 0; i < arry.length ; i++) {
			if(i == 0) {
				arry[0] = 0;
				continue;
			}
			
			if(i == 1) {
				arry[1] = 1;
				continue;
			}
			
			arry[i] = arry[i-1] + arry[i-2]; 
		}
		
		return arry;
	}
}
