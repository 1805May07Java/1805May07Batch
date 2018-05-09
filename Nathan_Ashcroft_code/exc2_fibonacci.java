package com.rev.questions;

public class exc2_fibonacci {

	
	public int[] fib(int[] in) {
		in[0] = 0;
		in[1] = 1;
		
		for(int i = 2; i < 25; i++) {
			in[i] = in[i-1] + in[i-2];			
		}
		
		return in;	
		
	}
}
