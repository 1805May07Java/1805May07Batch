package com.ex.classes;

public class ClassBasics {
	//INSTANCE VARS
	int a;
	double b;
	String c;
	
	//ClassBasics = new ClassBasics(1, 5.0, "hi");
	public ClassBasics(int a, double b, String c) {
		super();		//always first line of constructor -- in this case calls the Object classes Constructor
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	//no args constructor
	public ClassBasics() {
		this(5,2.3,"test"); 
	}
	
}
