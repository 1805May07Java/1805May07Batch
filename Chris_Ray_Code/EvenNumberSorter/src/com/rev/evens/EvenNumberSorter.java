package com.rev.evens;

import java.util.ArrayList;

public class EvenNumberSorter {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Integer> evens = new ArrayList<Integer>();
		
		
		for(int i = 1; i <= 100; i++) {
			nums.add(i); //was .add(new Integer(i)) in earlier versions
		}
		
		System.out.println(nums);
		
		for(int i : nums) {
			if(i % 2 == 0) {
				evens.add(i);
			}
		}
		
		System.out.println(evens);

	}

}
