package com.rev.exercise06;

public class Q6_IsItEven {
	public static void main(String[] args)
	{
		Q6_IsItEven control = new Q6_IsItEven();
		int check = Integer.parseInt(args[0]);
		
		String determine = control.isEven(check) ? "is" : "is not";
		
		System.out.println(check + " " + determine + " an even number.");
	}
	
	public boolean isEven(int check)
	{
		int checkA = check / 2;
		int checkB = (check + 1) / 2;
		
		return checkA == checkB;
	}
}
