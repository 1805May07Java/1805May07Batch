package com.rev.questions;

import com.rev.example.Example;

public class CrossPackageAccess {

	public static void main(String[] args) {
		System.out.println(Example.CONSTANT);
		System.out.println(new Example(3.283f).value);
	}
	
}
