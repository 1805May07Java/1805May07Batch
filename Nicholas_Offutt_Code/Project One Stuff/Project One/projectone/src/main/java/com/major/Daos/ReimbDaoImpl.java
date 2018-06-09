package com.major.Daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.major.pojos.ErsUser;
import com.major.pojos.Reimbursement;
import com.major.util.ConnectionFactory;

public class ReimbDaoImpl implements ReimbDao {
	final static Logger logger = Logger.getLogger(ReimbDaoImpl.class);

	
	@Override
	public Reimbursement getById(int id) 
	{
		Reimbursement output = new Reimbursement();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			//set up the query
			String sql = "select * from ERS_REIMBURSEMENT where REIMB_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rows = ps.executeQuery();
			
			while(rows.next()) 
			{
				output.setId(id);
				output.setAmount(rows.getDouble("REIMB_AMOUNT"));
				output.setTimeSubmitted(rows.getTimestamp("REIMB_SUBMITTED").toString());
				if(rows.getTimestamp("REIMB_RESOLVED")!=null) 
				{
					output.setTimeResolved(rows.getTimestamp("REIMB_RESOLVED").toString());
				}
				else
				{
					output.setTimeResolved("");
				}
				output.setDescription(rows.getString("REIMB_DESCRIPTION"));
				output.setRequesterId(rows.getInt("REIMB_AUTHOR"));
				output.setResolverId(rows.getInt("REIMB_RESOLVER"));
				output.setStatusId(rows.getInt("REIMB_STATUS_ID"));
				output.setTypeId(rows.getInt("REIMB_TYPE_ID"));
			}
			
		} 
		catch (SQLException e) 
		{
			logger.debug("Reimbursement DAO issue", e);
		
		}
		
		return output;
	}

	@Override
	public ArrayList<Reimbursement> getByAuthor(ErsUser requester) {
		
		
		ArrayList<Reimbursement> output = new ArrayList<Reimbursement>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			//set up the query
			String sql = "select * from ERS_REIMBURSEMENT where REIMB_AUTHOR = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, requester.getId());
			ResultSet rows = ps.executeQuery();
			
			
			while(rows.next()) 
			{
				Reimbursement temp = new Reimbursement();
				temp.setId(rows.getInt("REIMB_ID"));
				temp.setAmount(rows.getDouble("REIMB_AMOUNT"));
				temp.setTimeSubmitted(rows.getTimestamp("REIMB_SUBMITTED").toString());
				if(rows.getTimestamp("REIMB_RESOLVED")!=null) 
				{
					temp.setTimeResolved(rows.getTimestamp("REIMB_RESOLVED").toString());
				}
				else
				{
					temp.setTimeResolved("");
				}
				temp.setDescription(rows.getString("REIMB_DESCRIPTION"));
				temp.setRequesterId(rows.getInt("REIMB_AUTHOR"));
				temp.setResolverId(rows.getInt("REIMB_RESOLVER"));
				temp.setStatusId(rows.getInt("REIMB_STATUS_ID"));
				temp.setTypeId(rows.getInt("REIMB_TYPE_ID"));
				
				output.add(temp);
			}
		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.debug("Reimbursement DAO issue", e);
		}
		
		return output;
	}

	@Override
	public ArrayList<Reimbursement> getByResolver(ErsUser resolver) {

		ArrayList<Reimbursement> output = new ArrayList<Reimbursement>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			//set up the query
			String sql = "select * from ERS_REIMBURSEMENT where REIMB_RESOLVER = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, resolver.getId());
			ResultSet rows = ps.executeQuery();
			
			
			while(rows.next()) 
			{
				Reimbursement temp = new Reimbursement();
				temp.setId(rows.getInt("REIMB_ID"));
				temp.setAmount(rows.getDouble("REIMB_AMOUNT"));
				temp.setTimeSubmitted(rows.getTimestamp("REIMB_SUBMITTED").toString());
				temp.setTimeResolved(rows.getTimestamp("REIMB_RESOLVED").toString());
				temp.setDescription(rows.getString("REIMB_DESCRIPTION"));
				temp.setRequesterId(rows.getInt("REIMB_AUTHOR"));
				temp.setResolverId(rows.getInt("REIMB_RESOLVER"));
				temp.setStatusId(rows.getInt("REIMB_STATUS_ID"));
				temp.setTypeId(rows.getInt("REIMB_TYPE_ID"));
				
				output.add(temp);
			}
		
		} 
		catch (SQLException e) 
		{
			logger.debug("Reimbursement DAO issue", e);
		}
		
		return output;
		
	}

	@Override
	public Reimbursement createReimb(Reimbursement reimbCreate) 
	{
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			String[] keys = new String[1];
			keys[0] = "REIMB_ID";
			String sql = "insert into ERS_REIMBURSEMENT (REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_STATUS_ID, "
					+ "REIMB_TYPE_ID, REIMB_RESOLVER) values (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setDouble(1, reimbCreate.getAmount());
			ps.setString(2, reimbCreate.getDescription());
			ps.setInt(3, reimbCreate.getRequesterId());
			ps.setInt(4, 1);
			ps.setInt(5, reimbCreate.getTypeId());
			ps.setInt(6, 43);
			
			int rows = ps.executeUpdate();
			if(rows!=0) 
			{
				ResultSet rs = ps.getGeneratedKeys();
				while(rs.next()) 
				{
					reimbCreate.setId(rs.getInt(1));
				}
			}
			conn.commit();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.debug("Reimbursement DAO issue", e);
		}
		
		return reimbCreate;
	}

	@Override
	public Reimbursement updateReimb(Reimbursement reimbUpdate) 
	{
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			String[] keys = new String[1];
			keys[0] = "REIMB_RESOLVED";
			String sql = "{call reimbUpdate(?,?,?,?,?,?,?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, reimbUpdate.getId());
			call.setDouble(2, reimbUpdate.getAmount());
			call.setString(3, reimbUpdate.getDescription());
			call.setInt(4, reimbUpdate.getRequesterId());
			call.setInt(5, reimbUpdate.getResolverId());
			call.setInt(6, reimbUpdate.getStatusId());
			call.setInt(7, reimbUpdate.getTypeId());
			
			boolean flag = call.execute();
			if(flag) 
			{
				ResultSet rs = call.getGeneratedKeys();
				reimbUpdate.setTimeResolved(rs.getTimestamp(1).toString());
			}
			conn.commit();
		} 
		catch (SQLException e) 
		{
			
			logger.debug("Reimbursement DAO issue", e);
		}
		
		
		return reimbUpdate;
	}

	@Override
	public ArrayList<Reimbursement> getByType(int statusId) {
		ArrayList<Reimbursement> output = new ArrayList<Reimbursement>();
		
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			//set up the query
			String sql = "select * from ERS_REIMBURSEMENT where REIMB_STATUS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statusId);
			ResultSet rows = ps.executeQuery();
			
			
			while(rows.next()) 
			{
				Reimbursement temp = new Reimbursement();
				temp.setId(rows.getInt("REIMB_ID"));
				temp.setAmount(rows.getDouble("REIMB_AMOUNT"));
				temp.setTimeSubmitted(rows.getTimestamp("REIMB_SUBMITTED").toString());
				if(rows.getTimestamp("REIMB_RESOLVED")!=null) 
				{
					temp.setTimeResolved(rows.getTimestamp("REIMB_RESOLVED").toString());
				}
				else
				{
					temp.setTimeResolved("");
				}
				temp.setDescription(rows.getString("REIMB_DESCRIPTION"));
				temp.setRequesterId(rows.getInt("REIMB_AUTHOR"));
				temp.setResolverId(rows.getInt("REIMB_RESOLVER"));
				temp.setStatusId(rows.getInt("REIMB_STATUS_ID"));
				temp.setTypeId(rows.getInt("REIMB_TYPE_ID"));
				
				output.add(temp);
			}
			conn.commit();
		} 
		catch (SQLException e) 
		{
			logger.debug("Reimbursement DAO issue", e);
		}
		return output;
	}

	@Override
	public ArrayList<Reimbursement> getAll() {
		ArrayList<Reimbursement> output = new ArrayList<Reimbursement>();
		
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			//set up the query
			String sql = "select * from ERS_REIMBURSEMENT";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rows = ps.executeQuery();
			
			
			while(rows.next()) 
			{
				Reimbursement temp = new Reimbursement();
				temp.setId(rows.getInt("REIMB_ID"));
				temp.setAmount(rows.getDouble("REIMB_AMOUNT"));
				temp.setTimeSubmitted(rows.getTimestamp("REIMB_SUBMITTED").toString());
				if(rows.getTimestamp("REIMB_RESOLVED")!=null) 
				{
					temp.setTimeResolved(rows.getTimestamp("REIMB_RESOLVED").toString());
				}
				else
				{
					temp.setTimeResolved("");
				}
				temp.setDescription(rows.getString("REIMB_DESCRIPTION"));
				temp.setRequesterId(rows.getInt("REIMB_AUTHOR"));
				temp.setResolverId(rows.getInt("REIMB_RESOLVER"));
				temp.setStatusId(rows.getInt("REIMB_STATUS_ID"));
				temp.setTypeId(rows.getInt("REIMB_TYPE_ID"));
				
				output.add(temp);
			}
			conn.commit();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.debug("Reimbursement DAO issue", e);
		}
		
		return output;
	}

}
