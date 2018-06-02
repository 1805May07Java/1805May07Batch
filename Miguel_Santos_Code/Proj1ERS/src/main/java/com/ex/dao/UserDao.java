package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ex.pojos.ERSUser;
import com.ex.util.ConnectionFactory;

public class UserDao {

    public ERSUser getByUsername(String un) {
        ERSUser user = new ERSUser();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String query = "select * from ers_users where username = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, un);
            ResultSet rs = ps.executeQuery();

            rs.next();
            user.setId(rs.getInt(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setFirstname(rs.getString(4));
            user.setLastname(rs.getString(5));
            user.setEmail(rs.getString(6));
            user.setRoleId(rs.getInt(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public int isUsernameTaken(String un){
        int ret = 0;
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String query = "select count(*) from esr_users where username = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, un);
            ResultSet rs = ps.executeQuery();

            rs.next();
            ret = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
    public int isEmailTaken(String email){
        int ret = 0;
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String query = "select count(*) from esr_users where user_email = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            rs.next();
            ret = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
    public int validUnPw(String un, String pw) {
		int ret = 0;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select count(*) from ers_users where username = ? and user_password = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, un);
			ps.setString(2, pw);
			ResultSet rs = ps.executeQuery();

			rs.next();
			ret = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}


}