package com.rev.exercise13;

public class Q13_BinaryTriangle {
	
	public static void main(String[] args)
	{
		Q13_BinaryTriangle main = new Q13_BinaryTriangle();
		main.printBinaryTriangle(4);
	}
	
	public void printBinaryTriangle(int depth)
	{
		int b = 0;
		for(int i = 1; i <= depth; i++)
		{
			for (int j = 1; j <= i; j++)
			{
				System.out.print(b + " ");
				b = (b+1)%2;
			}
			System.out.println();
		}
	}
}
