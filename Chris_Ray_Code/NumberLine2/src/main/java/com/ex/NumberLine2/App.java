package com.ex.NumberLine2;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Integer> numberLine = new ArrayList<Integer>();
        
        for(int i = 1; i <= 100; i++) {
        	numberLine.add(i); //
        }
        
        for(Integer num : numberLine) {
        	if(num % 2 == 0 ) {
        		System.out.println(num);
        	}
        }
    }
}
