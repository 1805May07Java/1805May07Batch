package com.rev.factorial;

public class Factorial {

		public static void main(String args[]) {
			int i, factor = 1;
			//Hard code value to calculate
			int number=8;
			//Loop through integers and multiply
			for(i=1;i<=number;i++) {
			factor=factor*i;
			}
			
			System.out.println(factor);
		}		
}
