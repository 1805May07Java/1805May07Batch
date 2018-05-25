package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ex.pojo.Account;
import com.ex.util.ConnectionFactory;

public class AcctDao {

	public ArrayList<Account> getAll() {
		ArrayList<Account> accounts = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "select * from useraccount";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				Account temp = new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
				accounts.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return accounts;
	}

	public boolean hasAccount(int id, int select) {
		boolean temp = false;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select count(*) from useraccount where user_id = ? and acct_id = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, select);

			ResultSet rs = ps.executeQuery();

			rs.next();
			if(rs.getInt(1) == 0) temp = false;
			else temp = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	public int numOfAccts(int id) {
		int temp = 0;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select count(*) from useraccount where user_id = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			rs.next();
			temp = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	public ArrayList<String> getAcctBals(int id) {
		ArrayList<String> ret = new ArrayList<String>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select acct_table.acct_name, useraccount.balance from useraccount inner join "
					+ "acct_table on useraccount.acct_id = acct_table.ACCT_ID where useraccount.USER_ID = ?"
					+ "order by acct_table.acct_id asc";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				ret.add(rs.getString(1) + ":");
				ret.add("$" + new Double(rs.getDouble(2)).toString());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public double getBalance(int id, int select) {
		double ret = 0;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select balance from useraccount where user_id = ? and acct_id = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, select);

			ResultSet rs = ps.executeQuery();

			rs.next();
			ret = rs.getDouble(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	public void addAccount(int id, int select) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "insert into useraccount(balance, acct_id, user_id) values(0.01, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, select);
			ps.setInt(2, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateBal(double total, int id, int select) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "update useraccount set balance = ? where user_id = ? and acct_id = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, total);
			ps.setInt(2, id);
			ps.setInt(3, select);

			ps.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		}



	}
}
