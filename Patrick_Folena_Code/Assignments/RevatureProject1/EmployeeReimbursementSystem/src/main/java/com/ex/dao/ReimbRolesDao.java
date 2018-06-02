package com.ex.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ex.pojos.ReimbRole;
import com.ex.pojos.User;
import com.ex.util.ConnectionFactory;

public class ReimbRolesDao implements Dao{

	@Override
	public List<ReimbRole> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReimbRole findOne(Serializable id) {
		ReimbRole role = new ReimbRole();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_USER_ROLES WHERE ERS_USER_ROLE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (int)id);
			ResultSet info = ps.executeQuery();
			
			if(!info.next()) return null;
			role.setID(info.getInt(1));
			role.setRole(info.getString(2));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public ReimbRole save(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReimbRole update(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUnique(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
