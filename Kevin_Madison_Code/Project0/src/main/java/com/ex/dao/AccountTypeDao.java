package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.AccountType;
import com.ex.util.ConnectionFactory;

public class AccountTypeDao implements Dao<AccountType, Integer>{

	@Override
	public List<AccountType> getAll() {
		List<AccountType> accountTypes = new ArrayList<AccountType>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String query = "select * from account_type";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) { 
				AccountType temp = new AccountType();
				
				temp.setTypeId(rs.getInt(1)); //can access by name or index(starts with 1)
				temp.setType(rs.getString(2));
				accountTypes.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return accountTypes;
	}

	@Override
	public AccountType findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountType save(AccountType obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountType update(AccountType obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUnique(AccountType obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
