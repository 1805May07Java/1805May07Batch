package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rev.util.ConnectionFactory;

public class AccountTypeDAOImpl implements AccountTypeDAO{

	@Override
	public String getType(int id) {
		String a = "";
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "SELECT accounttype FROM accounttype WHERE accounttypeid = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a =  rs.getString(1);
			}
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

}
