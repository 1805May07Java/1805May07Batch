package com.major.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.major.pojos.ReimbType;
import com.major.util.ConnectionFactory;

public class ReimbTypeDaoImpl implements ReimbTypeDao {

	final static Logger logger = Logger.getLogger(ReimbTypeDaoImpl.class);
	@Override
	public ReimbType getType(int id) 
	{
		ReimbType output = new ReimbType();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "select * from ERS_REIMBURSMENT_TYPE where REIMB_TYPE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				output.setId(id);
				output.setType(rs.getString("REIMB_TYPE"));
			}
			
		} 
		catch (SQLException e)
		{
			logger.debug("ReimbType DAO issue", e);
		}
		return output;
	}

	@Override
	public int getId(String input) {
		
		int out = 0;
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "select * from ERS_REIMBURSMENT_TYPE where REIMB_TYPE = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, input);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				out = rs.getInt("REIMB_TYPE_ID");
			}
		} 
		catch (SQLException e) 
		{
			logger.debug("ReimbType DAO issue", e);
		}
		return out;
	}

	@Override
	public ArrayList<ReimbType> getAllTypes() {
		ArrayList<ReimbType> output = new ArrayList<ReimbType>();
		ReimbType temp = new ReimbType();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "select * from ERS_REIMBURSMENT_TYPE";
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) 
			{
				temp.setId(rs.getInt("REIMB_TYPE_ID"));
				temp.setType(rs.getString("REIMB_TYPE"));
				output.add(temp);
			}
			
		} 
		catch (SQLException e)
		{
			logger.debug("ReimbType DAO issue", e);
		}
		return output;
	}

}
