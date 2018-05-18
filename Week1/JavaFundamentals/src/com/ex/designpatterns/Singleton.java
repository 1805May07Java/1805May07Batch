package com.ex.designpatterns;

public class Singleton {
	
	String name;
	int count;
	
	private static Singleton singleton = new Singleton();
	
	//Key element of Singleton design pattern -- private constructor
	private Singleton() {
		super();
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
}
