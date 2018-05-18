package com.ex.datatypes;

import java.text.NumberFormat;

public class Casting {

	char cylinder = '\u0008';
	int cyl = cylinder; // implicit cast from char to integer 
	
	byte wheelbase =  90;
	int wBase = wheelbase; // implicit cast from byte to integer
	
	short horsepower = 250;
	int hPower = horsepower; // implicit cast from short to integer
	
	//int length = 151.1F;
	int length = (int)151.1F; // floats must be explicitly casted
	int power = (int) 405.1D; // doubles must be explicitly casted 
	
	long rent = 1_460_000L;
	long lowerRent = 146_000l;
	long r = (long) 5773; // explicit cast to long
	long e = 2380; // explicit cast to long 
	
	float aF = 1919537.0f;
	float bF = 4538495.12f;
	float cF = aF + bF;
	//Format the float into US currency
	String dF = NumberFormat.getCurrencyInstance().format(cF);
	// look at difference between cF and dF 
}
