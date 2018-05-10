package com.ex.multithreading;

import java.util.Random;

public class ConsumerProducer implements Runnable{

	public static void main(String[] args) {
		final Stuff stuff = new Stuff();
	}
	@Override
	public void run() {
		
		Thread t1 = new Thread(new runnable() {
			try {
				stuff.produce();
			}
		});
		
		public static class Stuff {
			static int stuff;
			
			public static void produce(){
				Random rand = new Random();
				stuff = rand.nextInt(100) + 1;
			}
			
			public static void consume() {
				stuff = 0;
			}
			
		}
		
	}
}


