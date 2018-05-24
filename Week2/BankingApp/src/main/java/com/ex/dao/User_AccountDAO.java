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
import com.ex.pojos.User_Account;
import com.ex.util.ConnectionFactory;

public class User_AccountDAO implements DAO<User_Account, Integer>
{

	@Override
	public List<User_Account> getAll() {
		
		return null;
	}

	@Override
	public User_Account find(Integer id) {
		
		return null;
	}

	@Override
	public User_Account save(User_Account obj) {
		int user = obj.getUser().getId();
		int acc = obj.getAcc().getId();
			
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "insert into user_account(user_id, account_id) values(?, ?)";
				
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user);
			ps.setInt(2, acc);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User_Account update(User_Account obj) {
		
		return null;
	}

	@Override
	public boolean isUnique(User_Account obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public void balances(Integer id)
	{
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM user_account inner JOIN bankuser on bankuser.user_id = user_account.user_id inner join bankaccount ON bankaccount.account_id=user_account.account_id";
			
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {  
				if(id == rs.getInt(1))
				{	
					String thing = "";
					int typeid = rs.getInt(10);
					if(typeid == 1)
					{
						thing = "Checking";
					}
					else if(typeid == 2)
					{
						thing = "Savings";
					}
					else
					{
						thing ="Credit";
					}
					System.out.println("You have $"+ rs.getDouble(11) + " in your " + thing + ".");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return;
	}
	
	public List<User_Account> findAll(Integer id)
	{
		List<User_Account> accs = new ArrayList<User_Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from user_account where user_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			
			while(info.next())
			{
				BankUser u = new BankUser();
				BankAccount a = new BankAccount();
				User_Account temp = new User_Account();
				u.setId(info.getInt(1));
				a.setId(info.getInt(2));
				temp.setUser(u);
				temp.setAcc(a);
				accs.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accs;
		
	}

}
