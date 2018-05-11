package com.designpatterns.single;

public class SingletonPattern 
{
	private static SingletonPattern onlyOne;
	
	private SingletonPattern() 
	{
		
	}
	
	public static SingletonPattern getOnly() 
	{
		
		
		if(onlyOne == null) 
		{
			onlyOne = new SingletonPattern();
		}
		
		return onlyOne;
	}
	
}
