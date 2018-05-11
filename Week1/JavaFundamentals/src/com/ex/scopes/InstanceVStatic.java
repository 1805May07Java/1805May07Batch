package com.ex.scopes;

public class InstanceVStatic {
	public static int number = 5; //First when the class loads
	
	//Second when the class the loads
	static {
		//System.out.println(number++); //Post increment -> 5
		//System.out.println(number);
		System.out.println("Static block: " + ++number); //Pre increment -> 6
		//System.out.println(nonStaticNumber); Can't reference non static field from static
	}
	
	public int nonStaticNumber = -5;
	
	//Fourth when you call the constructor (instantiate).
	{
		System.out.println("Non static block");
		System.out.println(nonStaticNumber);
	}
	
	public static void main(String[] args) { //args is only available in this method -> Method scope.
		System.out.println(args[0]);
		
		new InstanceVStatic();
		// -> CLASS scope (static)
		InstanceVStatic.number = 6;
		
		//ClassScope.nonStaticNumber ?? -> No, this is INSTANCE scope (non-static).
		int i = new InstanceVStatic().nonStaticNumber; //this works
		
		//Block scope
		{
			int block = 0;
			System.out.println(block); // -> Yes I can
		}
		//System.out.println(block); I can't
	}
}
