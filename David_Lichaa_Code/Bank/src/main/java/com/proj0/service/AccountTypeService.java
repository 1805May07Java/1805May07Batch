package com.proj0.service;

import com.proj0.dao.AccountTypeDAO;

public class AccountTypeService {
	static AccountTypeDAO adao = new AccountTypeDAO();
	
	public String getAccountTypeLabel(int id) {
		return adao.getAccountTypeLabel(id);
	}
}
