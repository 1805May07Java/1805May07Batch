package com.rev.questions;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class SwitchExample {
	
	public static void main(String[] args) {
		
		Random r = new Random();
		int option = r.nextInt(3);
		
		switch (option) {
		case 0:
			int num = r.nextInt();
			double sqrt = Math.sqrt((double) num);
			System.out.println("sqrt(" + num + ") = " + sqrt);
			break;
			
		case 1:
			System.out.println(new Date());
			break;
			
		case 2:
			String[] arr = "I am learning Core Java".split("\\s+");
			System.out.println(Arrays.toString(arr));
			break;
			
		default:
			throw new IllegalStateException();
		}
		
	}
}
