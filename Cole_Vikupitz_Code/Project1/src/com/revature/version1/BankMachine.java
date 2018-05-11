/*
 * BankMachine.java
 * Author: Cole Vikupitz
 *
 */

package com.revature.version1;

import java.util.Scanner;

public class BankMachine {

	private static Scanner scanner = new Scanner(System.in);

	public BankMachine() {

		this.scanner = new Scanner(System.in);
	}

	public void run() {

		this.getNumberInRange(5, 15);
	}

	private int getNumberInRange(int min, int max) {

		while (true) {
			System.out.print(">> ");
			try {
				int x = Integer.parseInt(scanner.nextLine());
				if (min <= x && x <= max)
					return x;
				throw new Exception();
			} catch (Exception e) {
				System.out.println("Not valid dude...");
			}
		}

	}

}
