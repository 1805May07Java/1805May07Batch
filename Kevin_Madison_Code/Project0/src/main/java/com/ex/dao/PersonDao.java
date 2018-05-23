package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Person;
import com.ex.util.ConnectionFactory;

public class PersonDao implements Dao<Person, Integer>{
	
	//return all people in the database
	public List<Person> getAll() {
		List<Person> userAccounts = new ArrayList<Person>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from Person";
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Person temp = new Person();
				temp.setPerson_id(rs.getInt(1));
				temp.setFirstname(rs.getString(2));
				temp.setLastname(rs.getString(3));
				temp.setUsername(rs.getString(4));
				temp.setPassword(rs.getString(5));
				userAccounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userAccounts;
	}
	
	//return a person based on the person id
	public Person findOne(Integer id) {
		Person temp = new Person();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			
			//TODO: change this sql statement to match the arg
			String sql = "select * from person where person_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();

			info.next();
			temp.setPerson_id(info.getInt(1));
			temp.setFirstname(info.getString(2));
			temp.setLastname(info.getString(3));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	//adding a new person to the DB
	public Person save(Person obj) {
		Person UserAccount = obj;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "insert into Person(firstname, lastname, username, password) VALUES (?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, obj.getFirstname());
			ps.setString(2, obj.getLastname());
			ps.setString(3, obj.getUsername());
			ps.setString(4, obj.getPassword());
			
			ps.executeUpdate();
			conn.commit();
			
			query = "select * from Person where username = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, obj.getUsername());
			ResultSet info = ps.executeQuery();
			info.next();
			UserAccount.setPerson_id(info.getInt(1));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UserAccount;
	}

	public Person update(Person obj) {
		return obj;
		
	}
	
	//check to see if the username is unique
	public boolean isUnique(Person obj) {
		String person_username = obj.getUsername();
		boolean exists = true;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from person where username = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, person_username);
			
			ResultSet info = ps.executeQuery();
			
			exists = info.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return exists;
	} 
	
	public Person getPersonByUsername(String username) {
		Person temp = new Person();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			
			//TODO: change this sql statement to match the arg
			String sql = "select * from person where username = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();

			info.next();
			temp.setPerson_id(info.getInt(1));
			temp.setFirstname(info.getString(2));
			temp.setLastname(info.getString(3));
			temp.setUsername(info.getString(4));
			temp.setPassword(info.getString(5));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

}
