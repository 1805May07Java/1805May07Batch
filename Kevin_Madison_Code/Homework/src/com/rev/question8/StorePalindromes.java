package com.rev.question8;

import java.util.ArrayList;

//Question 8: Write a program that stores the following strings in an ArrayList and save all the palindromes in another ArrayList.
//“karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
public class StorePalindromes {
	
	public static void main(String[] args) {
		//initialize variable
		ArrayList<String> list = new ArrayList<String>();
		
		//add to list
		list.add("karan");
		list.add("madam");
		list.add("tom");
		list.add("civic");
		list.add("radar");
		list.add("sexes");
		list.add("jimmy");
		list.add("kayak");
		list.add("john");
		list.add("refer");
		list.add("billy");
		list.add("did");
		
		System.out.println("\nAll the words in the first array list: ");
		for(String s: list) {
			System.out.print(s+" ");
		}
		
		
		ArrayList<String> tempList = palindromes(list);
		System.out.println("All the words that are palindromes: ");
		for(String s: tempList) {
			System.out.print(s+" ");
		}
		
		
	}
	
	public static ArrayList<String> palindromes(ArrayList<String> list){
		ArrayList<String> tempList = new ArrayList<String>();
		
		for(int i = 0; i < list.size() ; i++) {
			String str = list.get(i);
			StringBuilder sb = new StringBuilder(str);
			
			if(sb.reverse().toString().equals(str)) {
				tempList.add(sb.toString());
			}
		}
		return tempList;
	}

}
