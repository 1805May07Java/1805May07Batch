package com.rev.exercise14;

import java.util.Date;

public class Q14_BranchingTasks {
	public static void main(String[] args)
	{
		Q14_BranchingTasks main = new Q14_BranchingTasks();
		main.chooseOption(1, 100);
		main.chooseOption(2, 0);
		main.chooseOption(3, 0);
	}
	
	public void chooseOption(int option, float num)
	{
		switch(option) 
		{
		case 1:
			System.out.println("The square root of " + num + " is " + Math.sqrt(num));
			break;
		case 2:
			Date date = new Date();
			System.out.println("Today's Date : " + date.toString());
			break;
		case 3:
			String str = "I am learning core java";
			String[] splitStr = str.split(" ");
			System.out.print(splitStr.length + "...");
			for(int i = splitStr.length - 1; i >= 0; i--)
			{
				System.out.print(splitStr[i] + " ");
			}
			break;
		}
	}
}
