package com.ex.classes;

public class Calculator {

	public static void main(String[] args) {


		Calculable add = (a, b) -> {
			return a + b;
		};
		
		Calculable subtract = (a, b) -> {
			return a - b;
		};
		
		System.out.println(add.calculate(5, 6));
		System.out.println(subtract.calculate(12.3, 1895));

	}


}

@FunctionalInterface
interface Calculable{
	double calculate(double a, double b);
}