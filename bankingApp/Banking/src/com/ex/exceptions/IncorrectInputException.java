package com.ex.exceptions;




public class IncorrectInputException extends Exception{
	
	public IncorrectInputException() {
		super("Invalid Input. Please try again");
	}
}
