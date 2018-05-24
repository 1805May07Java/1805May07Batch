package com.rev.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Customer;
import com.rev.util.ConnectionFactory;


public class CustomerDao {
	
	public Customer save(Customer obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "insert into customer(username, acc_id) values (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, obj.getUsername());
			ps.setInt(2, obj.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findOne(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object save(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object update(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isUnique(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
