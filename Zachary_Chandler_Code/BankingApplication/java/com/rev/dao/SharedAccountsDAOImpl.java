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

public class SharedAccountsDAOImpl implements SharedAccountsDAO {

	public SharedAccountsDAOImpl() {
		
	}

	@Override
	public void share(Account account, Customer other) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			PreparedStatement st = conn.prepareStatement("insert into sharedaccounts values(?, ?)");
			st.setLong(1, account.getAccountID());
			st.setLong(2, other.getCustomerID());
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isShared(Account account, Customer other) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			PreparedStatement st = conn.prepareStatement("select * from SharedAccounts where accountid=? and customerid=?");
			st.setLong(1, account.getAccountID());
			st.setLong(2, other.getCustomerID());
			ResultSet rs = st.executeQuery();
			
			return rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Account[] getShared(Customer user) {
		
		List<Account> accounts = new ArrayList<>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			PreparedStatement st = conn.prepareStatement("select * from account where accountid in "
					+ "(select accountid from sharedaccounts where customerid=?)");
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

}
