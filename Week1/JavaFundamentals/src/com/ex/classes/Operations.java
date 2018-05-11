package com.ex.classes;

public enum Operations {
	
	ADD, SUBTRACT, MULTIPLY, DIVIDE, MOD;
	
	public double calculate(double a, double b) {
		switch(this) {
		case ADD: return a + b; 
		case SUBTRACT: return a - b;
		case MULTIPLY: return a * b;
		case DIVIDE: return a / b;
		case MOD: return a % b;
		default: return 0;
		
		}
	}

}
