package com.rev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.rev.pojos.Account;
import com.rev.dao.AccountDao;


public class AccountService {
	static AccountDao accountdao = new AccountDao();
	
	public AccountDao getAllAccounts(){
		return accountdao;
	}
	public void add(Account a) {
		accountdao.save(a);
	}
	
	public List<Account> getAll(){
		return accountdao.getAll();
	}
			
	public static Account addAccount(String username, String password, int type, double balance) {
		int id = (int)( Math.random()*10000);
				
		Account s = new Account(id, username, password, type, balance); 
		AccountDao dao = new AccountDao();
		dao.addAccount(s);
		return s;
	}
	
	public static Account getBalance(double balance) {
		Account s = new Account();
		AccountDao dao = new AccountDao();
		dao.getBalance(s);
		return s;
	}
	public static void setSpouse(String spouse) {
					
		}

	public static void setType(int type) {
		// TODO Auto-generated method stub
		
	}
	public static void jointAccount(int type) {
		System.out.println("Enter joint account holder's name");
		Scanner scan = new Scanner(System.in);
		String spouse = scan.nextLine();
		setSpouse(spouse);
		setType(type);
						
		//accept spouse nameString spouse = scan.nextLine();
		
	}
	
	public static void savingsAccount(int type) {
		System.out.println("Okay, thanks.");
		
	}

	public static void checkingAccount(int type) {
		System.out.println("Okay, thanks.");
		
	}
	
	public static void creditAccount(int type) {
		System.out.println("Okay, thanks.");
		
	}
	
	//public static void Account.setBalance() {
}
	