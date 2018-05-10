package com.rev.switchex;

import java.lang.Math;
import java.time.LocalDateTime;

public class SwitchExamples {

	public static void main(String[] args) {
		
		showSwitch(1);
		showSwitch(2);
		showSwitch(3);

	}
	
	public static void showSwitch(int n) {
		
		String[]sentence;
		
		switch(n) {
		case 1: System.out.println(Math.sqrt(25)); break;
		case 2: System.out.println(LocalDateTime.now()); break;
		case 3: {sentence = "I am learning core Java".toString().split(" "); System.out.println(sentence[3]);} break;
		default: break;
		}
	}

}
