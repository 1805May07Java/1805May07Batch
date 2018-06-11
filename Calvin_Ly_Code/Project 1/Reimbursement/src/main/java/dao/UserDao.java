package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.User;

public class UserDao {

    public User getByUsername(String un) {
        User user = new User();
        try (Connection conn = util.ConnectionFactory.getInstance().getConnection()) {
            String query = "select * from users where username = ?";

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
        try(Connection conn = util.ConnectionFactory.getInstance().getConnection()){
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
        try(Connection conn = util.ConnectionFactory.getInstance().getConnection()){
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
    public int validate(String un, String pw) {
        System.out.println("in dao");
        int ret = 0;
        try(Connection conn = util.ConnectionFactory.getInstance().getConnection()){
            String query = "select count(*) from users where username = ? and password = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, un);
            ps.setString(2, pw);
            ResultSet rs = ps.executeQuery();

            rs.next();
            ret = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }


}