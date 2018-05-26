package com.ex.fibnacci;

public class FibnacciSequence {

	public static void main(String[] args) {
		int a = 0; 
		int b = 1; 
		int c = 0;
		
		while (c < 89)
		{
			a = b;
			b = c;
			c = a + b;
			System.out.println(c);
			
		}
		
	}
}
