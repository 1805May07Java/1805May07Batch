package ers.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ers.pojos.User;
import ers.util.ConnectionFactory;
public class UserDAO {
	public List<User> getAll() {
		ArrayList<User> users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_users";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setFirstName(rs.getString(4));
				u.setLastName(rs.getString(5));
				u.setEmail(rs.getString(6));
				u.setRoleId(rs.getInt(7));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
