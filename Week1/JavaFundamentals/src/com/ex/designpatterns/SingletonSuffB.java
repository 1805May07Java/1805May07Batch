package com.ex.designpatterns;


//Java program to create Thread Safe
//Singleton class
public class SingletonSuffB 
{
	// private instance, so that it can be
	// accessed by only by getInstance() method
	private static SingletonSuffB instance;
	
	private SingletonSuffB()
	{
		//private constructor
	}
	
	//synchronized method to control simultaneous access
	synchronized public static SingletonSuffB getInstance()
	{
		if (instance == null) 
	    {
	      // if instance is null, initialize
	      instance = new SingletonSuffB();
	    }
	    return instance;
	}
	
}
//A thread safe singleton in created so that singleton property is maintained even in multithreaded environment. 
//To make a singleton class thread-safe, getInstance() method is made synchronized so that multiple threads can’t access it simultaneously.
/*Pros:
	Lazy initialization is possible.
	It is also thread safe.
  Cons:
	getInstance() method is synchronized so it causes slow performance as multiple threads can’t access it simultaneously.
*/