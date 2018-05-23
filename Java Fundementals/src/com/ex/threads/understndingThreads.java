package com.ex.threads;

public class understndingThreads {
	
	public static void main(String[] args) {
		/*for (int i = 0; i < 20; i++) {
			System.out.println("IN MAIN LOOP: " + i);
		}
		looping();*/
		
		ExtendsThread et = new ExtendsThread();
		et.start();
		
		ExtendsThread et2 = new ExtendsThread();
		et2.start();
		
		implementsRunable ir = new implementsRunable();
		Thread irRun = new Thread(ir);
		irRun.start();
		
		
		//shortcut for class not written when you only need to use it once
		/*Runnable lambda = () -> {
			for (int i = 0; i < 20; i++) {
				System.out.println("IN LAMBDA LOOP: " + i);
			}
		};*/
		
		
		//ANONYMOUS CLASS
		Runnable nested = new  Runnable() {
			//int count = 0;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		nested.run();
		
		/*Thread anotherThread = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
			}
		};*/
		
	}
	
	static void looping() {
		for (int i = 0; i < 20; i++) {
			System.out.println("IN LOOPING LOOP: " + i);
		}
	}
}

