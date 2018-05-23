package com.rev.designpatterns;

public class Singleton {

	String name;
	int count;
	
	
	private static Singleton singleton = new Singleton();
	private Singleton() {
		super();
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
}
