package com.major.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.major.pojos.ReimbStatus;
import com.major.util.ConnectionFactory;

public class ReimbStatusDaoImpl implements ReimbStatusDao 
{
	final static Logger logger = Logger.getLogger(ReimbStatusDaoImpl.class);

	@Override
	public ReimbStatus getStatus(int id) 
	{
		ReimbStatus output = new ReimbStatus();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "select * from ERS_REIMBURSEMENT_STATUS where REIMB_STATUS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				output.setId(id);
				output.setStatus(rs.getString("REIMB_STATUS"));
			}
			
		} 
		catch (SQLException e)
		{
			logger.debug("ReimbStatus DAO issue", e);
		}
		return output;
	}

	@Override
	public int getId(String input) 
	{
		int out = 0;
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "select * from ERS_REIMBURSEMENT_STATUS where REIMB_STATUS = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, input);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				out = rs.getInt("REIMB_STATUS_ID");
			}
		} 
		catch (SQLException e) 
		{
			logger.debug("ReimbStatus DAO issue", e);
		}
		return out;
	}

	@Override
	public ArrayList<ReimbStatus> getAllStatuses() 
	{
		ArrayList<ReimbStatus> output = new ArrayList<ReimbStatus>();
		ReimbStatus temp = new ReimbStatus();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "select * from ERS_REIMBURSEMENT_STATUS";
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) 
			{
				temp.setId(rs.getInt("REIMB_STATUS_ID"));
				temp.setStatus(rs.getString("REIMB_STATUS"));
				output.add(temp);
			}
			
		} 
		catch (SQLException e)
		{
			logger.debug("ReimbStatus DAO issue", e);
		}
		return output;
	}

}
