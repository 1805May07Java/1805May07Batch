package com.rev.dao;

import com.rev.pojos.Account;
import java.util.ArrayList;

public interface AccountDAO {
	public ArrayList<Account> getAll();
	public Account getById(int id);
	public ArrayList<Account> getAllByUser(int userId);
	public void addAccount(Account acc);
	public void updateAccount(Account acc);
}
