package com.ex.inheritance;

public interface Livable {
	
	void breathe();
	
	void consume();
	
	int reproduce();
	
	default void stayinAlive() {
		System.out.println("this is survival of the fittest");
	}
}
