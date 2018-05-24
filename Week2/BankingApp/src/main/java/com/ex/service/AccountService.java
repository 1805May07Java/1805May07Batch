package com.ex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ex.dao.BankAccountDAO;
import com.ex.dao.DAO;
import com.ex.dao.User_AccountDAO;
import com.ex.pojos.BankAccount;
import com.ex.pojos.BankUser;
import com.ex.pojos.User_Account;

public class AccountService 
{
	static Scanner scan = new Scanner(System.in);
	static DAO<BankAccount, Integer> accdao = new BankAccountDAO();
	static DAO<User_Account, Integer> joindao = new User_AccountDAO();
	
	public BankAccount addAccount(BankAccount acc) {
		
		return accdao.save(acc);
	}
	
	public void addUserAccount(BankUser a, BankAccount b) {
		joindao.save(new User_Account(a, b));
	}
	
	
	public void checkBalance(BankUser s)
	{
		((User_AccountDAO) joindao).balances(s.getId());
		return;
	}
	
	public void withdraw(BankUser s)
	{
		int acctype = 0;
		System.out.println("From which account?");
		acctype = Integer.parseInt(scan.nextLine());
		if(acctype != 1 || acctype != 2 || acctype != 3)
		{
			System.out.println("Sorry, not a valid option.");
			withdraw(s);
		}
		System.out.println("How much would you like to withdraw?");
		double amount = Double.parseDouble(scan.nextLine());
		List<User_Account> accounts = ((User_AccountDAO) joindao).findAll(s.getId());
		for(User_Account a : accounts)
		{
			if(a.getAcc().getId() == acctype)
			{
				BankAccount acc = ((BankAccountDAO) accdao).findOne(a.getAcc().getId(), acctype);
				if(acc.getBalance() > amount)
				{
					amount = acc.getBalance()-amount;
					((BankAccountDAO)accdao).update(acc, amount);
				}
				else
				{
					System.out.println("That is more than your account has.  Nice try, try again.");
					withdraw(s);
					return;
				}
				
				
			}
		}
		
	}
	
	public void createAccount(BankUser s)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("What kind of account would you like to create?\n" +
				"1: Checking\n" + 
				"2: Savings\n" + 
				"3: Credit");
		int at = Integer.parseInt(scan.nextLine());
		System.out.println(at);
		if((at != 1) && (at != 2) && (at != 3))
		{
			System.out.println("That was an invaild entry. Please try again");
			createAccount(s);
			return;
		}

		System.out.println("Please enter your initial account balance:\n");
		double balance = 0;
		try{
			balance = in.nextDouble();
		}catch(NumberFormatException nfe)
		{
			System.out.println("Not a valid balance. Please try again.");
			createAccount(s);
			return;
		}
		BankAccount acc = new BankAccount(at, balance);
		acc = addAccount(acc);
		BankUser next = new BankUser(s.getId(), s.getFn(), s.getLn(), s.getUsername(), s.getEmail(), s.getPassword());
		addUserAccount(next, acc);
		return;
	}
	
	public void linkAccount(BankUser s)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the account number you would like to link to.");
		int accnum = Integer.parseInt(in.nextLine());
		BankAccount linked = new BankAccount();
		linked.setId(accnum);
		addUserAccount(s,linked);
		
	}

	public void deposit(BankUser s) {
		int acctype = 0;
		System.out.println("To which account?");
		acctype = Integer.parseInt(scan.nextLine());
		System.out.println("How much would you like to deposit?");
		double amount = Double.parseDouble(scan.nextLine());
		List<User_Account> accounts = ((User_AccountDAO) joindao).findAll(s.getId());
		for(User_Account a : accounts)
		{
			if(a.getAcc().getId() == acctype)
			{
				BankAccount acc = ((BankAccountDAO) accdao).findOne(a.getAcc().getId(), acctype);
				amount = acc.getBalance()+amount;
				((BankAccountDAO)accdao).update(acc, amount);
			}
		}
		
		
		
	}

}
