package com.rev.substring;

//import java.util.*;

public class SubString {

	public static void main(String[] args) {
		
		String s = getSubString("aardvaark", 7);
		System.out.println(s);
	}
	
	public static String getSubString(String str, int idx) {
		
		byte[]arr = str.getBytes();
		byte[]arr2 = new byte[idx];
		
		for(int i = 0; i < idx; i++) {
			arr2[i] = arr[i];
		}
		
		String s = new String(arr2); //creates the new string that will be returned
		return s;
	}

}
