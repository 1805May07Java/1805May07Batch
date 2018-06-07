package com.revature.main;

import com.revature.pojos.User;
import com.revature.service.UserService;

public class Driver {

	public static void main(String[] args) {

		User user = UserService.authenticate("cvikupitz@gmail.com", "p4ssw0rd1");
		System.out.println(user != null ? user : "INVALID CREDENTIALS");
	}
}
