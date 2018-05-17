package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rev.pojo.Customer;
import com.rev.util.ConnectionFactory;

public class CustomerDAOImpl implements CustomerDAO {

	public CustomerDAOImpl() {
		
	}

	@Override
	public boolean exists(String email) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			PreparedStatement st = conn.prepareStatement("select * from customer where email=?");
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			
			return rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Customer create(String email, String password, String firstName, String lastName) {

		Customer customer = null;

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			PreparedStatement st = conn.prepareStatement("insert into customer values(default, ?, ?, ?, ?)");
			st.setString(1, email);
			st.setString(2, password);
			st.setString(3, firstName);
			st.setString(4, lastName);
			st.executeUpdate();
			
			customer = get(email);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	}

	@Override
	public Customer get(String email) {

		Customer customer = new Customer();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			PreparedStatement st = conn.prepareStatement("select * from customer where email=?");
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				customer.setCustomerID(rs.getLong(1));
				customer.setEmail(rs.getString(2));
				customer.setPassword(rs.getString(3));
				customer.setFirstName(rs.getString(4));
				customer.setLastName(rs.getString(5));
			} else {
				customer = null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			customer = null;
		}
		
		return customer;
	}

	@Override
	public Customer get(long customerID) {
		Customer customer = new Customer();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String query = "select * from customer where customerid=" + customerID;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next()) {
				customer.setCustomerID(rs.getLong(1));
				customer.setEmail(rs.getString(2));
				customer.setPassword(rs.getString(3));
				customer.setFirstName(rs.getString(4));
				customer.setLastName(rs.getString(5));
			} else {
				customer = null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	}

}
