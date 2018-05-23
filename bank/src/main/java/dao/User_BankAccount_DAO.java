package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbc.ConnectionFactory;
import pojo.BankAccount;
import pojo.User;
import pojo.User_BankAccount;

public class User_BankAccount_DAO {
	
	
	public static User_BankAccount insert(User u, BankAccount b) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
			
			String[] keys = new String[2];
			keys[0] = "bankaccount_id";
			keys[1] = "user_id";
			
			String query = "insert into bankaccounts_users (bankaccount_id, user_id) values ( ? , ? )";
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setInt(1, b.getId());
			ps.setInt(2, u.getId());
			
			int rows = ps.executeUpdate();
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					conn.commit();
					return new User_BankAccount(u,b);
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<BankAccount> getAllAccounts(String username) {
		ArrayList<BankAccount> list = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			int id = UserDAO.getByUsername(username).getId();
			String query = 	"select bankaccount_id, account_type, balance " + 
					"from bankaccounts join bankaccounts_users on bankaccounts.id = bankaccounts_users.BANKACCOUNT_id " + 
					"where bankaccounts_users.user_id = " + id;
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				BankAccount temp = new BankAccount();
				temp.setId(rs.getInt(1));
				temp.setAccount_type(rs.getInt(2));
				temp.setBalance(rs.getDouble(3));
				list.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
