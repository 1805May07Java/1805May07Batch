package com.ex.inheritance;

public abstract class Animal implements Livable{
	
	void communicate(String content) {
		System.out.println("I am talking: " + content);
	}

}
