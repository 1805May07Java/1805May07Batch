/*package com.rev.assignment;

public class producerConsumberProblem {
	public static void main(String[] args) {
		
		final pc prodCon = new pc();
		
		Thread th1 = new Thread(new Runnable() {

			@Override
			public void run() {
			//	prodCon.produce();
			}
		};
		
		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
			//	prodCon.consume();
			}
		};
		
		th1.start();
		th2.start();
		
		th1.join();
		th2.join();
	}
}
*/