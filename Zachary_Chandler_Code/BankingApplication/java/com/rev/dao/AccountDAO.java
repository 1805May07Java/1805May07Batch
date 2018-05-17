package com.rev.dao;

import com.rev.pojo.Account;
import com.rev.pojo.AccountType;
import com.rev.pojo.Customer;

public interface AccountDAO {

	Account[] getAccounts(Customer user);

	void updateBalance(Account userAccounts);

	void createAccount(Customer user, AccountType checking);

}