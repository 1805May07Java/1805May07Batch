package com.ex.classes;

public class Driver {

	public static void main(String[] args) {
		//create new user
		User u;

		System.out.println("we have declared the user..now about to instantiate");

		u = new User();
		System.out.println("instantiated user");
		u.setFirstname("Genesis");
		u.setAge(100);

		System.out.println(u.toString());
		
		
		//Working with enums
		Operations o = Operations.SUBTRACT;
		
		System.out.println(o.calculate(4.0, 2.0));
	}

}
