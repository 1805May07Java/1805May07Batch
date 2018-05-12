/*
 * Driver.java
 * Author: Cole Vikupitz
 *
 * Driver file containing main() that runs the program.
 */

package com.revature.version1;

/*
 * TODO:
 * password validity
 * read/write users to/from file
 * add more options?
 *     display balance?
 *     change password?
 * menu cancellation options?
 */

public class Driver {

	public static void main(String[] args) {

		new BankMachine().run();
	}
}
