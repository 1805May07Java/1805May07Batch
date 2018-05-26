package com.ex.service;

import com.ex.dao.TransactionDao;
import com.ex.dao.Dao;
import com.ex.pojos.Transaction;;

public class TransactionService {
	static Dao<Transaction, Integer> Transactiondao = new TransactionDao();
}
