package com.rev.dao;

import com.rev.pojo.Account;
import com.rev.pojo.Customer;

public interface SharedAccountsDAO {

	void share(Account userAccounts, Customer other);

	boolean isShared(Account userAccounts, Customer other);

	Account[] getShared(Customer user);

}