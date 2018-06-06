package com.ex.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.ReimbRole;
import com.ex.pojos.ReimbStatus;
import com.ex.util.ConnectionFactory;

public class ReimbStatusDao implements Dao<ReimbStatus, Integer>{

	@Override
	public List<ReimbStatus> getAll() {
		List<ReimbStatus> statusList = new ArrayList<ReimbStatus>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_STATUS";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet info = ps.executeQuery();
			while(info.next()){
				ReimbStatus status = new ReimbStatus();
				status.setID(info.getInt(1));
				status.setStatus(info.getString(2));
				statusList.add(status);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return statusList;
	}

	@Override
	public ReimbStatus findOne(Integer id) {
		ReimbStatus status = new ReimbStatus();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_STATUS WHERE REIMB_STATUS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (int)id);
			ResultSet info = ps.executeQuery();
			
			if(!info.next()) return null;

			status.setID(info.getInt(1));
			status.setStatus(info.getString(2));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ReimbStatus save(ReimbStatus obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReimbStatus update(ReimbStatus obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUnique(ReimbStatus obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
