package com.rev.excersizes;

public class Driver {

	public static void main(String[] args) {
		//create new user
		User u = new User();
		u.setFirstName("Nathan");
		u.setAge(100);
		
		System.out.println(u.toString());
		
		
		//enums
		Operations o = Operations.ADD;
		System.out.println(o.calculate(4.0, 2.0));
		
		int x = 72000;
		short c = (short) x;
		System.out.println(c);
	}
}
