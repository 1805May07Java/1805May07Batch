package com.rev.excersizes;

public class calculator {
	
	public static void main(String[] args) {
		Calculatable add = (a, b) -> {
			return a + b;
		};
		
		Calculatable subtract = (a, b) -> {
			return a - b;
		};
		
		System.out.println(add.calculate(5, 6));
		System.out.println(subtract.calculate(12.3,  1895));
	}
	
	
}

@FunctionalInterface
interface Calculatable{
	double calculate(double a, double b);
}