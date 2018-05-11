package com.ex.designpatterns;

//Java code to create singleton class by 
//Eager Initialization
public class SingletonStuffA 
{
	// public instance initialized when loading the class
	public static SingletonStuffA instance = new SingletonStuffA();
	
	private SingletonStuffA()
	{
		// private constructor
	}
}
//This is the simplest method of creating a singleton class. In this, object of class is created when it is loaded to the memory by JVM. 
//It is done by assigning the reference an instance directly.
//It can be used when program will always use instance of this class, or the cost of creating the instance is not too large in terms of resources and time.
//Pros:
/*	Very simple to implement.
	No need to implement getInstance() method. Instance can be accessed directly.
  Cons:
	May lead to resource wastage. Because instance of class is created always, whether it is required or not.
	CPU time is also wasted in creation of instance if it is not required.
	Exception handling is not possible.*/