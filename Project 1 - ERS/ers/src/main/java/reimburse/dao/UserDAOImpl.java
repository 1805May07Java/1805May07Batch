package reimburse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import reimburse.jdbc.ConnectionFactory;
import reimburse.pojo.User;

public class UserDAOImpl implements UserDAO {

	static ArrayList<User> list = new ArrayList<User>();
		
	@Override
	public ArrayList<User> getAll() {
		list.clear();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from ERS_USERS";	
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				User temp = new User();
				temp.setId(rs.getInt(1)); //can access by name or index(starts with 1)
				temp.setUsername(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFirstname(rs.getString(4));
				temp.setLastname(rs.getString(5));
				temp.setEmail(rs.getString(6));
				temp.setRole(rs.getString(7));
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User getUser(String username) {
		for(User u : list) {
			if(u.getUsername().equals(username)) {
				return u;
			}
		}
		return null;
	}
	
	@Override
	public User getUser(int id) {
		for(User u : list) {
			if(u.getId() == id) {
				return u;
			}
		}
		return null;
	}
	
	@Override
	public User insertUser(String...inputs) {
		String username = inputs[0];
		String password = inputs[1];
		String firstname = inputs[2];
		String lastname = inputs[3];
		String email = inputs[4];
		int role = getRole(inputs[5]);
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
			String query = "insert into ERS_USERS (ERS_username,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) "
					+ "values (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, firstname);
			ps.setString(4, lastname);
			ps.setString(5, email);
			ps.setInt(6, role);
					
			ps.executeQuery();
			conn.commit();
			return getUser(username);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	private static int getRole(String role) {
		return role.equalsIgnoreCase("employee") ? 1 : 2;
	}
}
