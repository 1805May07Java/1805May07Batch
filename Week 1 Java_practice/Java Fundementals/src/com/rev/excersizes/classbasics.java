package com.rev.excersizes;

public class classbasics {
	
	//instance vars
	int a;
	double b;
	String c;
	
	static {
		System.out.println("in static block");
	}
	
	//class basics cb = new classbasics(1,5.0,"hi")
	public classbasics(int a, double b, String c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		System.out.println("in 3 arg");
	}
	public classbasics(int a2) {
		this(a2, 2.3, "test");
		System.out.println("in 1 arg");
	}
	public classbasics(int a, double b) {
		a = 10;
		b = 5.7;
		c = "test";
		System.out.println("this is 2 arg");
	}
	public classbasics() {
		this(5,2.3,"test");
	}
	
	public static void main(String[] args) {
		System.out.println("in main");
		//classbasics cb = new classbasics(6);
	}
}
