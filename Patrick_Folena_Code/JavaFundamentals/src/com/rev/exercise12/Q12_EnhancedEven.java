package com.rev.exercise12;

public class Q12_EnhancedEven {
	
	int[] arr;
	
	public static void main(String[] args)
	{
		Q12_EnhancedEven main = new Q12_EnhancedEven();
		main.printEven(main.incIntArray(100));
	}
	
	public int[] incIntArray(int maxNum)
	{
		arr = new int[maxNum];
		for(int i = 0; i < maxNum; i++)
		{
			arr[i] = i+1;
		}
		return arr;
	}
	
	public void printEven(int[] arr)
	{
		for(int n : arr)
		{
			System.out.print( (n%2 == 0)?(n + " "):(""));
		}
	}
}
