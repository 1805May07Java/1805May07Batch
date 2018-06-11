package com.bank.dao;

import com.bank.pojos.User;
import com.bank.util.ConnectionFactory;
import oracle.jdbc.internal.OracleTypes;

import java.sql.*;
import java.util.ArrayList;


public class UserDAOImpl implements UserDAO{
    @Override
    public ArrayList<User> readUsers() {
        ArrayList<User> users = new ArrayList<User>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String query = "select * from users";

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                User temp = new User();
                temp.setId(rs.getInt("USER_ID")); //can access by column name or column index
                temp.setUsername(rs.getString(2));
                temp.setPassword(rs.getString(3));
                temp.setFirstname(rs.getString(4));
                temp.setLastname(rs.getString(5));
                temp.setAddress(rs.getString(6));
                temp.setCity(rs.getString(7));
                temp.setState(rs.getString(8));
                temp.setCountry(rs.getString(9));
                temp.setPhone(rs.getString(10));
                temp.setEmail(rs.getString(11));
                users.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    @Override
    public ArrayList<User> getUser(String username){
        ArrayList<User> users = new ArrayList<User>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String query = "select * from users where username = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                User temp = new User();
                temp.setId(rs.getInt(1));
                temp.setUsername(rs.getString(2));
                temp.setPassword(rs.getString(3));
                temp.setFirstname(rs.getString(4));
                temp.setLastname(rs.getString(5));
                temp.setAddress(rs.getString(6));
                temp.setCity(rs.getString(7));
                temp.setState(rs.getString(8));
                temp.setCountry(rs.getString(9));
                temp.setPhone(rs.getString(10));
                temp.setEmail(rs.getString(11));
                users.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    @Override
    public void addUser(User newUser) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            conn.setAutoCommit(false);
            String query = "insert into users (username, password, firstname, lastname, address, city, state, country, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, newUser.getUsername());
            ps.setString(2, newUser.getPassword());
            ps.setString(3, newUser.getFirstname());
            ps.setString(4, newUser.getLastname());
            ps.setString(5, newUser.getAddress());
            ps.setString(6, newUser.getCity());
            ps.setString(7, newUser.getState());
            ps.setString(8, newUser.getCountry());
            ps.setString(9, newUser.getPhone());
            ps.setString(10, newUser.getEmail());
            ps.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
