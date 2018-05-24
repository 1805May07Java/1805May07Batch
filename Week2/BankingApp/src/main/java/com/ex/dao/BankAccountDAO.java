package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.BankAccount;
import com.ex.pojos.BankUser;
import com.ex.util.ConnectionFactory;

public class BankAccountDAO implements DAO<BankAccount, Integer>
{

	@Override
	public List<BankAccount> getAll() {
		List<BankAccount> acc = new ArrayList<BankAccount>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from bankaccount";
			
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {  
				BankAccount temp = new BankAccount();
				temp.setId(rs.getInt(1)); 
				temp.setTypeId(rs.getInt(2));
				temp.setBalance(rs.getDouble(3));
				acc.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return acc;
	}

	public BankAccount findOne(Integer id, Integer type) {
		BankAccount chosen = new BankAccount();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from bankaccount where account_id = ? and type_id = ?";
			
			String[] keys = new String[2];
			keys[0] = "account_id";
			keys[1] = "type_id";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setInt(1, id);
			ps.setDouble(2, type);
			

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {  
				
				chosen.setId(rs.getInt(1)); 
				chosen.setTypeId(rs.getInt(2));
				chosen.setBalance(rs.getDouble(3));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chosen;
	}

	@Override
	public BankAccount save(BankAccount obj) {
		BankAccount acc = new BankAccount();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "insert into bankaccount(type_id, balance) "
					+ "values(?, ?)";
			
			String[] keys = new String[1];
			keys[0] = "account_id";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setInt(1, obj.getTypeId());
			ps.setDouble(2, obj.getBalance());
					
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					acc.setId(pk.getInt(1));
				}
				
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}

	public void update(BankAccount obj, double amount) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "update bankaccount set balance = ? where account_id = ? and type_id = ?";
			
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, amount);
			ps.setInt(2, obj.getId());
			ps.setInt(3, obj.getTypeId());
					
			int rows = ps.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean isUnique(BankAccount obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BankAccount update(BankAccount obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccount find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
