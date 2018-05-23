package com.ex.inharitence;

public interface Livable {
	
	void breathe();
	
	void consume();
	
	int reproduce();
	
	default void stayinAlive() {
		System.out.println("this is survival of the fittest");
	}
}
