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

	public List<AccountType> getAll() {
		List<AccountType> types = new ArrayList<AccountType>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from accounttype";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) { //Author: author_id, firstname, lastname, bio 
				AccountType temp = new AccountType();
				temp.setId(rs.getInt(1)); //can access by name or index(starts with 1)
				temp.setName(rs.getString(2));
				temp.setDescription(rs.getString(3));
				types.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return types;
	}

	public AccountType findOne(Integer id) {
		
		AccountType at = new AccountType();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from accounttype where accounttypeid = ?";

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			while(rs.next()) { //Author: author_id, firstname, lastname, bio 
				at.setId(rs.getInt(1));
				at.setName(rs.getString(2));
				at.setDescription(rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return at;
	}

	public AccountType save(AccountType obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountType update(AccountType obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isUnique(AccountType obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
