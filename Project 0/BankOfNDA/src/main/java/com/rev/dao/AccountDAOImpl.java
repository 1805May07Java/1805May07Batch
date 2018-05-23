package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rev.pojos.Account;
import com.rev.util.ConnectionFactory;

public class AccountDAOImpl implements AccountDAO{

	@Override
	public ArrayList<Account> getAll() {
		ArrayList<Account> a = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select * from account";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				Account tmp = new Account();
				tmp.setAccID(rs.getInt(1));
				tmp.setAccType(rs.getInt(2));
				tmp.setUserID(rs.getInt(3));
				tmp.setBalance(rs.getDouble(4));

				a.add(tmp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}

	@Override
	public Account getById(int id) {
		Account a = new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select * from account WHERE accountid = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				a.setAccID(rs.getInt(1));
				a.setAccType(rs.getInt(2));
				a.setUserID(rs.getInt(3));
				a.setBalance(rs.getDouble(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}

	@Override
	public void addAccount(Account acc) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "insert into account(ACCOUNTTYPE, USERID, BALANCE) Values(?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, acc.getAccType());
			ps.setInt(2, acc.getUserID());
			ps.setDouble(3, acc.getBalance());

			int rs = ps.executeUpdate();

			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateAccount(Account acc) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "UPDATE account SET balance = ? WHERE accountid = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, acc.getBalance());
			ps.setInt(2, acc.getAccID());
			System.out.println(acc.getBalance() + " " + acc.getAccID());
			int rs = ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Account> getAllByUser(int userId) {
		ArrayList<Account> a = new ArrayList<Account>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select * FROM ACCOUNT WHERE USERID = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, (Integer)userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Account tmp = new Account();
				tmp.setAccID(rs.getInt(1));
				tmp.setAccType(rs.getInt(2));
				tmp.setUserID(rs.getInt(3));
				tmp.setBalance(rs.getDouble(4));
				a.add(tmp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}

}
