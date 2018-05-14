package com.ex.scopes;

public class Scopes {
	
	/* Scopes
	 * The lifetime of a variable
	 * There are four different scopes in Java
	 * Class/Static = This is what we usually mean by global
	 * 		Variables in this scope exist for the lifetime of the program
	 * 		and exist within the class itself.
	 * Object/Instance = the object's fields/state
	 * 		Variables in this scope exist for the lifetime of an object
	 * 		and exist with the object itself
	 * Method = mostly parameters and any variables defined at the method level
	 * 		Variables in this scope exist for the lifetime of a  method call
	 * Loop/Block = any variables defined within curly braces
	 */
	
	/*
	 * static fields
	 * instance fields
	 * blocks
	 * constructor
	 * static methods ?
	 * methods ?
	 */
	public Scopes() {
		System.out.println("Constructor");
	}
	
	{
		System.out.println("Instance Block");
		// j lives, i lives
		i = 4;
		j = 4;
	}
	
	static {
		System.out.println("Static block");
		// i lives
		i = 2;
	}
	
	// Static scope
	public static int i;
	// Instance scope
	public int j;
	
	String test;
	
	public static void main(/* method scope */ String[] args) {
		String test = "testing";
		
		
		System.out.println("Main method");
		// method scope
		int k;
		
		//block scope
		for (int l = 0; l< 3; l++) {
			// l lives, k lives, i lives
			i = 5;
			// j = 5;
			k = 5;
			l = 5;
		}
		
		// k lives, i lives
		i = 3;
		// j = 3;
		k = 3;
		// l = 3;
		
		Scopes s = new Scopes();
		s.method(k);
	}

	private void method(int hi) {
		// j lives, i lives
		i = 5;
		j = 5;
		// k = 5;
		// l = 5;
	}

}
