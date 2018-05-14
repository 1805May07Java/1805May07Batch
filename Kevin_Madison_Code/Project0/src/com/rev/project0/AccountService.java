package com.rev.project0;

import java.util.ArrayList;

public class AccountService {
	static ArrayList<Account> accounts;
	static {
		accounts = new ArrayList<Account>();
		accounts.add(new Account("kevin", "madison", "kevinmadison", "password", 1000.0));
	}

	ArrayList<Account> getAllAccounts() {
		// until we deal w DAO, all we do here is return our static arraylist

		IODAO dao = new IODAO();
		return dao.readAccounts();
	}

	boolean exists(String username) {
		ArrayList<Account> accounts = getAllAccounts();
		return accounts.stream().anyMatch(s -> s.getUsername().equalsIgnoreCase(username));
	}

	Account getByUsername(String username) {
		return getAllAccounts().stream().filter(s -> s.getUsername().equalsIgnoreCase(username)).findFirst().get();
	}

	Account addAccount(String fn, String ln, String username, String password, double balance) {
		Account s = new Account(fn, ln, username, password, balance);
		IODAO dao = new IODAO();
		dao.addAccount(s);
		return s;
	}

	void updateBalance(Account acc) {
		IODAO dao = new IODAO();
		ArrayList<Account> tempAccounts = dao.readAccounts();

		for (Account a : tempAccounts) {
			if (a.getUsername().equals(acc.getUsername())) {
				a.setBalance(acc.getBalance());
			}
		}
		dao.updateAccount(tempAccounts);
	}

	void logout(String username) {
		// save information and save into the text doc
	}
}
