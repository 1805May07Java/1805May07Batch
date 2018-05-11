package com.revhomework.Question15;

public class CalcTest {

	public static void main(String[] args) 
	{
		//make a new calculator
		Calculator test = new Calculator();
		
		
		//see what we get
		System.out.println(test.addition(6, 4));
		System.out.println(test.subtraction(7, 3));
		System.out.println(test.multiplication(16, 3));
		System.out.println(test.division(15, 5));
		System.out.println(test.modulus(27, 8));
			
	}

}
