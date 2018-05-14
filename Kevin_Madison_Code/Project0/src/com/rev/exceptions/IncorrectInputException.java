package com.rev.exceptions;

public class IncorrectInputException extends Exception {

	public IncorrectInputException() {
		super("Invalid input. Please try again");
	}
}