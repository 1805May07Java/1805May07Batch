package com.rev.questions;

public class CharacterCount {

	public static void main(String[] args) {
		System.out.println(count(args[0]));
	}
	
	public static int count(String input) {
		return input.length();
	}
}
