package com.ex.classes;

public class RunUsers {

	public static void main(String[] args) {
		//create new user
		User u;

		System.out.println("we have declared the user..now about to instantiate");

		u = new User();
		System.out.println("instantiated user");
		u.setFirstname("Genesis");
		u.setAge(100);

		System.out.println(u.toString());
	}

}
