package com.major.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.major.pojos.ErsUser;
import com.major.pojos.Reimbursement;
import com.major.util.ConnectionFactory;

public class ReimbDaoImpl implements ReimbDao {

	
	@Override
	public Reimbursement getById(int id) 
	{
		Reimbursement output = new Reimbursement();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			//set up the query
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rows = ps.executeQuery();
			
			while(rows.next()) 
			{
				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return output;
	}

	@Override
	public ArrayList<Reimbursement> getByAuthor(ErsUser obj) {
		
		// TODO Auto-generated method stub
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			//set up the query
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rows = ps.executeQuery();
			
			while(rows.next()) 
			{
				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<Reimbursement> getByResolver(ErsUser obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement createReimb(Reimbursement obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement updateReimb(Reimbursement obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
