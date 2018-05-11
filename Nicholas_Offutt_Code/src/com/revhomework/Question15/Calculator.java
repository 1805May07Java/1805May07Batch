package com.revhomework.Question15;

public class Calculator implements Mathable 
{

	@Override //simple override addition
	public double addition(double a, double b) 
	{
		return a + b;
	}

	@Override //simple override subtraction
	public double subtraction(double a, double b) 
	{
		return a-b;
	}

	@Override //simple override multiplication
	public double multiplication(double a, double b) 
	{
		return a*b;
	}

	@Override //simple override division
	public double division(double a, double b)
	{
	
		return a/b;
	}

	@Override //simple override modulus
	public double modulus(double a, double b)
	{
		
		return a%b;
	}

}
