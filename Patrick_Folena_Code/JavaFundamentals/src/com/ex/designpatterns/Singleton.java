package com.ex.designpatterns;

public class Singleton {
	
	private static Singleton singleton = new Singleton();
	
	String name;
	int count;
	
	//Key element of Singleton design pattern -- private constructor
	private Singleton() {
		super();
	}
	
	public static Singleton getInstance()
	{
		return singleton;
	}
}