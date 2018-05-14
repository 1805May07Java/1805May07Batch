package com.ex.classes;

public class ClassBasics {
	
	//INSTANCE VARS
	int a;
	double b;
	String c;
	
	static {
		System.out.println("in static block BEFORE MAIN");
	}
	
	//ClassBasics cb = new ClassBasics(1, 5.0, "hi");
	public ClassBasics(int a2, double b2, String c2) {
		super(); //always first line of constructor(*) -- in this case calls the Object classes constructor
		a = a2;
		this.b = b2;
		this.c = c2;
		System.out.println("in three arg constructor");
	}
	

	public ClassBasics(int a, double b) {
		a = 10;
		b = 5.7;
		c = "test";
		System.out.println("in two arg constructor");
	}
	
	public ClassBasics(int a2) {
		this(a2, 5, "hi");
		System.out.println("in 1 arg constructor");
	}
	
	//no arg constructor. if no constructor is defined, this is the default constructor
//	public ClassBasics() {
//		
//	}
//	
	public static void main(String[] args) {
		System.out.println("in main method");
		ClassBasics cb = new ClassBasics(6);
		
	//	ClassBasics x = new ClassBasics();
	}
	
	static {
		System.out.println("in static block AFTER MAIN");
	}
	
	
	

}
