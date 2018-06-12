package com.ex.hello;

public class ParentWorld {
	
	private HelloWorld hello;
	
	public ParentWorld() {
		super();
		System.out.println("in parent world no arg constructor");
	}

	public ParentWorld(HelloWorld hello) {
		super();
		this.hello = hello;
		System.out.println("in parent world one arg constructor");
	}

	public HelloWorld getHello() {
		return hello;
	}

	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}
	
	
	
	

}
