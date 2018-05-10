package com.ex.threads;

public class UnderstandingThreads implements Runnable {
	
	
	public static void main(String[] args) {
		for(int i = 0; i<20; i++) {
			System.out.println("In Main Loop: " + i);
		}
		looping();
	}
	
	
	Runnable lambda = () -> {
		for (int i = 0; i < 20; i++) {
			System.out.println("In Lambda Loop: " + i);
		}
	};
	
	lambda.run();
	
	static void looping(){
		for(int i = 0; i<20; i++) {
			System.out.println("In the looping loop: " + i);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
