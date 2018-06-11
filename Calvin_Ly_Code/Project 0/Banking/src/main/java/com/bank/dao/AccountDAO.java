package com.bank.dao;

import com.bank.pojos.Account;
import com.bank.pojos.User;

import java.util.ArrayList;

public interface AccountDAO {
    void newAccount(Account account, User user);
    double getBalance(Account userAccount);
    void updateBalance(Account userAccount);
    ArrayList<Account> findAccounts(User user);
}
