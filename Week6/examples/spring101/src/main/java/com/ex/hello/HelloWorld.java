package com.ex.hello;

public class HelloWorld {
	
	private String text;
	public int count;
	
	public HelloWorld() {}
	public HelloWorld(int count) {
		super();
		this.count = count;
	}

	public String getText() {
		System.out.println("IN HELLO WORLD GET TEXT: " + text);
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void initializeBean() {
		System.out.println("INITIALIZING BEAN");
	}
	
	public void destroyBean() {
		System.out.println("DESTROYING BEAN");
	}

}
