package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import jdbc.ConnectionFactory;
import pojo.BankAccount;

public class BankAccountDAO {

	
	public static ArrayList<BankAccount> getAll() {
		ArrayList<BankAccount> list = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from bankaccounts";	
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				BankAccount temp = new BankAccount();
				temp.setId(rs.getInt("id")); //can access by name or index(starts with 1)
				temp.setBalance(rs.getDouble(2));
				temp.setAccount_type(rs.getInt(3));
				list.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static BankAccount insertBankAccount(double balance, int account_type) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);

			String[] keys = new String[3];
			keys[0] = "id";
			keys[1] = "balance";
			keys[2] = "account_type";
			
			String query = "insert into bankaccounts (balance, account_type) values ( ? , ? )";
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setDouble(1, balance);
			ps.setInt(2, account_type);
			
			int rows = ps.executeUpdate();
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					BankAccount temp = new BankAccount();
					temp.setId(pk.getInt(1)); //can access by name or index(starts with 1)
					temp.setBalance(pk.getDouble(2));
					temp.setAccount_type(pk.getInt(3));
					conn.commit();
					return temp;
				}
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public static void deposit(BankAccount b, double amt) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);

			String query = "update bankaccounts set balance= ? where id= ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, b.getBalance() + amt);
			ps.setInt(2, b.getId());
			ps.executeUpdate();
			conn.commit();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static double withdraw(BankAccount b, double amt) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);

			String call = "{?= call withdraw(?,?)}";
			CallableStatement cs = conn.prepareCall(call);  
			cs.registerOutParameter(1, Types.DOUBLE);
			cs.setInt(2, b.getId());
			cs.setDouble(3, amt);
			cs.execute();
			
			conn.commit();
			return cs.getDouble(1);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b.getBalance();
	}
}
