package com.rev.question2;
//Question 2: Write a program to display the first 25 Fibonacci numbers beginning at 0. 
public class Fibonacci {

	public static void main(String[] args) {
		System.out.println("The following is the first 25 fibonacci numbers beginning at 0:");
		
		//use an array dummy
		int a = 0, b = 0;
		int c = 1;
		for(int i = 0; i < 25 ; i++) {
			if(i == 0) {
				a = 0;
				b = 1;
				continue;
			}
			c = a+b;
			b = ;
			b = c;
			System.out.println(c);
			
		}
	}
}
