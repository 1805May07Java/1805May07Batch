package com.rev.exercise02;

public class Q2_Fibonacci {

	final static double PHI = 1.61803398874989484820458683436563811772;
	public static void main(String[] args)
	{
		Q2_Fibonacci control = new Q2_Fibonacci();
		
		control.printFibonacciSequence(25);
	}
	
	public void printFibonacciSequence(int count)
	{
		int a = 0;
		int b = 1;
		int temp = 0;
		
		for (int i = 0; i < count; i++)
		{
			System.out.print(a + " ");
			temp = b;
			b = a + b;
			a = temp;
		}
	}
	
	//Fibonacci Indexed Value Approximation Equation
	public long Fibonacci(int index)
	{
		return Math.round(Math.pow(PHI, index) / Math.pow(5, 0.5));
	}
}
