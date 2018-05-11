package com.ex.threads;

public class UnderstandingThreads {
	/* https://www.javaworld.com/article/2074217/java-concurrency/java-101--understanding-java-threads--part-1--introducing-threads-and-runnables.html
	 * 
	 * A thread is a line of execution
	 * Multithreading in Java is more than one thread executing at the same time
	 */

	
	public static void main(String[] args) {
//		for (int i = 0; i < 20; i ++) {
//			System.out.println("IN MAIN LOOP: " + i);
//		}
//		looping();
		
		//Causes this thread to begin execution; the Java Virtual Machine calls the run method of this thread.
		ExtendsThread et = new ExtendsThread();
		et.start();
		
		ExtendsThread et2 = new ExtendsThread();
		et2.start();
		
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread irRun = new Thread(ir);
		irRun.start();
		
		
		//FunctionInterface name = (parameters) -> implementation of method
		Runnable lambda = () -> {
			for (int i = 0; i < 20; i ++) {
				System.out.println("IN LAMBDA LOOP: " + i);
			}
		};/*
		 Runnable lamda = new [class that we havent written. that contains this for loop as its run method implementation
		*/
		lambda.run();
		
		
		
		AnotherOne one = new AnotherOne();
		one.run();
		
		
		
		//ANONYMOUS CLASS
		Runnable nested = new Runnable() {
			int count = 0;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		nested.run();

		//ANON CLASS EXTENDING THREAD
		Thread anonthread = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
			}
		};
		
		
	}
	
	static void looping() {
		for (int i = 0; i < 20; i ++) {
			System.out.println("IN LOOPING LOOP: " + i);
		}
	}
}



class AnotherOne implements Runnable{

	@Override
	public void run() {
		//add functionality 
		
	}
	
}
