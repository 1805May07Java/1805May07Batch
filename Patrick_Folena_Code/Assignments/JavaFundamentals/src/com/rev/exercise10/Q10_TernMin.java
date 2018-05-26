package com.rev.exercise10;

public class Q10_TernMin 
{
	public static void main(String[] args)
	{
		Q10_TernMin main = new Q10_TernMin();
		System.out.println(main.minNum(1, 2));
		System.out.println(main.minNum(2, 1));
		System.out.println(main.minNum(2, 2));
	}
	
	public int minNum(int num1, int num2)
	{
		return num1 <= num2 ? num1 : num2;
	}

}
