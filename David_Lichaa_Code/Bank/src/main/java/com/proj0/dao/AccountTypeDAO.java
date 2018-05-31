package com.proj0.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proj0.util.ConnectionFactory;

public class AccountTypeDAO {
	//Given an id, return whatever account type (string) our lookup table associates the id with
	public String getAccountTypeLabel(int id) {
		String label = "";
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select Account_type_label from account_type where account_type_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			label = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return label;
	}
}
