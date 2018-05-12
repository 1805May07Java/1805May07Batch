/*
 * Driver.java
 * Author: Cole Vikupitz
 *
 * Driver class containing main() that runs the program.
 */

package com.revature.version1;

/*
 * TODO:
 * read/write users to/from file
 * add more options?
 *     display balance?
 *     change password?
 * menu cancellation options?
 * deposit/withdraw success message?
 * comments
 * clean files
 */

public class Driver {

	public static void main(String[] args) {

		new BankMachine().run();
	}
}
