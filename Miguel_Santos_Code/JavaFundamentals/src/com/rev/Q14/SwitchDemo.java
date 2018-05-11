package com.rev.Q14;

import java.time.*;

public class SwitchDemo {

	public static void switches(int x) {
		switch (x) {
		case 1: 
			int numb = 121;
			System.out.println("The sqaure root of 121 is " + Math.sqrt(numb));
			break;
		case 2:
			LocalDate today = LocalDate.now();
			System.out.println(today);
			break;
		case 3:
			String[] strArr;
			String s = "I am learning Core Java";
			strArr = s.split(" ");
			for(String n : strArr) System.out.println(n);
			break;
		default:
			System.out.println("No match found");
			break;
		}
	}
	
}
