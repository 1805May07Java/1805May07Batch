package com.rev.bank;

import java.util.ArrayList;

import com.rev.dao.AccountDAO;
import com.rev.dao.AccountDAOImpl;
import com.rev.dao.AccountTypeDAO;
import com.rev.dao.AccountTypeDAOImpl;
import com.rev.dao.UserDAO;
import com.rev.dao.UserDAOImpl;
import com.rev.pojos.Account;
import com.rev.pojos.User;

public class bankService {

	public boolean exists(String userName) {
		UserDAO dao = new UserDAOImpl();
		return dao.findUser(userName);
	}

	public User getByUserName(String userName) {
		UserDAO dao = new UserDAOImpl();
		return dao.getUser(userName);
	}

	public void addUser(String fName, String lName, String userName, String password) {
		UserDAO dao = new UserDAOImpl();
		User u = new User(fName, lName, userName, password);
		dao.addUser(u);
	}

	public ArrayList<Account> getaccounts(User curUser) {
		AccountDAO dao = new AccountDAOImpl();
		return dao.getAllByUser(curUser.getUserID());
	}

	public String getAccountType(int accType) {
		AccountTypeDAO a = new AccountTypeDAOImpl();
		return a.getType(accType);
	}

	public void withMoney(Account account) {
		AccountDAO dao = new AccountDAOImpl();
		dao.updateAccount(account);
	}

	public void addMoney(Account account) {
		AccountDAO dao = new AccountDAOImpl();
		dao.updateAccount(account);
	}

	public void addAccount(Account a) {
		AccountDAO dao = new AccountDAOImpl();
		dao.addAccount(a);
		
	}

}
