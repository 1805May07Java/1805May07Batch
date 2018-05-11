package com.rev.questions;

import java.util.Arrays;

public class Triangle {

	public static void main(String[] args) {
		
		boolean state = false;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print(state ? "1" : "0");
				state = !state;
			}
			
			System.out.println();
		}
		
	}
	
	public static String triangle(int n) {
		
		if (n < 0) {
			throw new IllegalArgumentException();
		}

		boolean state = false;
		
		String[] lines = new String[n];
		
		Arrays.fill(lines, "");
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < i + 1; j++) {
				lines[i] += state ? "1 " : "0 ";
				state = !state;
			}
			
			lines[i] = lines[i].trim();
			lines[i] += '\n';
		}
		
		StringBuilder result = new StringBuilder();

		for (String s : lines) {
			result.append(s.toString());
		}
		
		return result.toString();
	}

}
