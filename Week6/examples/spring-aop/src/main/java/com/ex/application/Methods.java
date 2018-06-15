package com.ex.application;

import org.springframework.stereotype.Component;

@Component
public class Methods {

	public String test() {
		return "In TEST() Method-----";
	}
	
	public void exceptionTest() throws RuntimeException {
		System.out.println("IN EXCEPTIONTEST() method----");
		throw new RuntimeException();
	}
	
	public int counter(int c) throws InterruptedException {
		for(int i = 0; i < c; i++) {
			Thread.sleep(i);
			System.out.println(i);
		}
		return c;
	} 
	
}
