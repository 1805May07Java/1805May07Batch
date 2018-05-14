package com.rev.exercise04;

public class Q4_NFactorial {
	public static void main(String[] args)
	{
		Q4_NFactorial control = new Q4_NFactorial();
		
		int i = Integer.parseInt(args[0]);
		
		System.out.print(i + "! : ");
		
		long answer = control.factorial(i);
		
		if(answer == -1)
		{
			System.out.print("No factorial could be determined");
		}
		else
		{
			System.out.print(answer);
		}
	}
	
	public long factorial(int fact)
	{
		if(fact < 0)
		{
			return -1;
		}
		
		long sum = fact--;
		while(fact > 0)
		{
			sum *= fact;
			fact--;
		}
		return sum;
	}
}
