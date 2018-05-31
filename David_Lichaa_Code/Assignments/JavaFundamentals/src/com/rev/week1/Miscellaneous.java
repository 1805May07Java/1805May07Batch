package com.rev.week1;

public class Miscellaneous {
	public static void printTriangle(int size) {
		int j = 0;
		for(int i=0; i<size; i++) {
			boolean onOff = false;
			j = 0;
			System.out.println();
			while (j <= i) {
				if (onOff) {
					System.out.print("0");
				} else {
					System.out.print("1");
				}
				onOff = !onOff;      //after every number print, the number will alternate
				j++;
			}
		}
	}
}
