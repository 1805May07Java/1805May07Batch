package com.rev.week1;

import java.util.ArrayList;

public class MyMath {
	public static boolean isEven(int n) {
		boolean even = false;
		Integer i = n;
		String s = i.toString();
		switch(s.charAt(s.length() - 1)) {
			case '0':
			case '2':
			case '4':
			case '6':
			case '8': even = true; //if the last digit of the integer is any of these 5 values, the value must be even
		}
		return even;
	}
	
	public static String getFibonacci(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		StringBuilder str = new StringBuilder();
		for (int i=0; i < n; i++) {
			if (i == 0) {
				list.add(0);
			}
			else if (i == 1) {
				list.add(1);
			} else {
				list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
			}
		}
		for (int i=0; i<list.size()-1; i++) {
			str.append(list.get(i) + ", ");
		}
		str.append(list.get(list.size()-1));
		return str.toString();
	}
	
	public static int factorial(int n) {
		if (n == 0) { //base case for recursion
			return 1;
		} else {
			return n * factorial(n-1); 
		}		
	}

	public static void printArrayEvens() {
		//create array from 1 to 100
		int[] list = new int[100];
		for (int i=0; i < 99; i++) {
			list[i+1] = (i+1);
		}
		for (int i: list) {
			if (MyMath.isEven(i)) {
				System.out.print(i + ", ");
			}
		}
	}

	public static int myMinimum(int n1, int n2) {
		int result = (n1 < n2) ? n1 : n2;
		return result;
	}
	
	public static boolean isPrime(int num) { 
		boolean bool = true;
		if (num == 1) { //special case, since we skip in for-loop below
			return false;
		}
		for (int i=2; i<num; i++) { //iterate through values 1...num. check remainders of each value. skip first two -- trivial
			if (num % i == 0) { //if we find a factor in any of the values in our array that mods 0, we know it is 
							    //composite
				bool = false;
				break;
			}
		}
		return bool;
	}
}
