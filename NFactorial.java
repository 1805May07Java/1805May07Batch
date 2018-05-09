package com.rev.exercises;

import java.util.Scanner;

public class NFactorial 
{
	public static int Factorial(int n)
	{
		int num = n;
		for(int i = n; i > 1; i--)
		{
			num = num * (n-1);
			n--;
		}
		
		return num;
	}
	
	public static void main(String args[])
	{
		int n;
		int answer;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter an integer for an the n!:");
		n = in.nextInt();
		
		answer = Factorial(n);
		System.out.println(answer);
		
	}
}
