package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojo.Account;
import com.rev.pojo.AccountType;
import com.rev.pojo.Customer;
import com.rev.util.ConnectionFactory;

public class AccountDAOImpl implements AccountDAO {

	public AccountDAOImpl() {
		
	}

	@Override
	public Account[] getAccounts(Customer user) {
		
		List<Account> accounts = new ArrayList<>();
		

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			PreparedStatement st = conn.prepareStatement("select * from account where customerid=?");
			st.setLong(1, user.getCustomerID());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Account a = new Account();

				a.setAccountID(rs.getLong(1));
				a.setCustomerID(rs.getLong(2));
				a.setType(AccountType.values()[rs.getInt(3) - 1]);
				a.setBalance(rs.getLong(4));
				
				accounts.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accounts.toArray(new Account[accounts.size()]);
	}

	@Override
	public void updateBalance(Account account) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			PreparedStatement st = conn.prepareStatement("update account set balance = ? where accountid=?");
			st.setLong(1, account.getBalance());
			st.setLong(2, account.getAccountID());
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createAccount(Customer user, AccountType type) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			PreparedStatement st = conn.prepareStatement("insert into account values(default, ?, ?, 0)");
			st.setLong(1, user.getCustomerID());
			st.setLong(2, AccountType.value(type));
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
