package com.ex.threads;

public class implementsRunable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 2000; i = i+96) {
			System.out.println("IN IR LOOP: " + i);
		}
	}

}
