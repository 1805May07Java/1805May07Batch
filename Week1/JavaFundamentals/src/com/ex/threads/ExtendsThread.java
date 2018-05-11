package com.ex.threads;

public class ExtendsThread extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 2000; i = i + 23) {
			System.out.println("IN ET LOOP: " + i);
			if(i%50 == 0) {
				try {
					this.wait(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
