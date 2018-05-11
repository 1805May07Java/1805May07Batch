package com.rev.questions;

public class PrintEvens {

	public static void main(String[] args) {
		int n = 100;
		
		int[] nums = new int[n];
		
		for (int i = 1; i <= n; i++) {
			nums[i-1] = i;
		}
		
		for (int i : nums) {
			if ((i & 1) == 0) {
				System.out.print(i + ", ");
			}
		}
	}

}
