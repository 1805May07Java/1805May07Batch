package com.ex.GigaShot;

import java.util.regex.Pattern;

public class GigaShot extends Shot{

	public GigaShot() {
		
	}
	
	public boolean checkIfUpperCaseLettersArePresent(String str) {
		char ch;
	    boolean capitalFlag = false;
	    for(int i=0;i < str.length();i++) {
	        ch = str.charAt(i);
	        if (Character.isUpperCase(ch)) {
	            capitalFlag = true;
	        }
	    }
	    
	    return capitalFlag;
	}
	
	public String toUpperCase(String str) {
		return str.toUpperCase();
	}
	
	public void add10AndPrint(String str) {
		System.out.println(Integer.parseInt(str) + 10);
	}
	

}
