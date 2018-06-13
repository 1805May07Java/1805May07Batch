package com.ex.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.beans.AccountType;
import com.ex.util.ConnectionUtil;

public class AccountTypeRepository implements Repository<AccountType, Integer> {

	@Override
	public List<AccountType> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountType findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountType save(AccountType obj) {
		try(Session session = ConnectionUtil.getSession()){
			Transaction tx = session.beginTransaction();
			int id = (Integer) session.save(obj);
			tx.commit();
			obj.setId(id);
		}
		return obj;
	}

	@Override
	public AccountType update(AccountType obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountType findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(AccountType obj) {
		// TODO Auto-generated method stub
		
	}

}
