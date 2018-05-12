package com.rev.questions;

import java.util.ArrayList;

public class exc8_arrayList {
	//Write a program that stores the following strings in an ArrayList and saves all the 
	//palindromes in another ArrayList.
	//“karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
	private static ArrayList<String> list = new ArrayList<String>();
	private static ArrayList<String> palindromes = new ArrayList<String>();
	
	
	public void sort(String str) {	
		int i = 0;
	    int j = str.length() - 1;
	   
	    while (j > i) {
	        if (str.charAt(i) != str.charAt(j)) {
	        	list.add(str);
	        	return;
	        }
	        i++;
	        j--;
	    }
	    palindromes.add(str);
		
	}
	
	public ArrayList<String> getList() {
		return list;
	}
	public void setList(ArrayList<String> list) {
		this.list = list;
	}
	public ArrayList<String> getPalindromes() {
		return palindromes;
	}
	public void setPalindromes(ArrayList<String> palindromes) {
		this.palindromes = palindromes;
	}
	
	
}
