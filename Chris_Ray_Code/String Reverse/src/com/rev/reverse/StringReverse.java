package com.rev.reverse;

import java.util.*;

public class StringReverse {

	public static void main(String[] args) {
		
		String s1 = "helloworld";
		char[] s3 = s1.toCharArray();
		 
        for (int i = s3.length-1; i>=0; i--)
            System.out.print(s3[i]);

	}
	
}
