package com.ex.threads;

public class ImplementsRunnable implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 2000; i = i + 96) {
			System.out.println("IN IR LOOP: " + i);
		}
		
	}

	
}
