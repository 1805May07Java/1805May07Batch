package com.ex.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.ReimbStatus;
import com.ex.pojos.ReimbType;
import com.ex.util.ConnectionFactory;

public class ReimbTypeDao implements Dao {

	@Override
	public List<ReimbType> getAll() {
		List<ReimbType> typelist= new ArrayList<ReimbType>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_TYPE";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet info = ps.executeQuery();
			
			while(info.next())
			{
				ReimbType type = new ReimbType();
				type.setID(info.getInt(1));
				type.setType(info.getString(2));
				typelist.add(type);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return typelist;
	}

	@Override
	public ReimbType findOne(Serializable id) {
		ReimbType type= new ReimbType();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_TYPE WHERE REIMB_TYPE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (int)id);
			ResultSet info = ps.executeQuery();
			
			if(!info.next()) return null;

			type.setID(info.getInt(1));
			type.setType(info.getString(2));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return type;
	}

	@Override
	public ReimbType save(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReimbType update(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUnique(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
