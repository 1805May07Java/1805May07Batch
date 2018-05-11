package com.revature.dao;

public class InvalidInputException extends Exception {

	public InvalidInputException() {
		super("Invalid input, please try again.");
	}
}
