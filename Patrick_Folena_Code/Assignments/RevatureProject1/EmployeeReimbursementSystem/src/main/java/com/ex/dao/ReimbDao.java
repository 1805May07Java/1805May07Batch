package com.ex.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Reimbursement;
import com.ex.pojos.User;
import com.ex.util.ConnectionFactory;

public class ReimbDao implements Dao<Reimbursement, Integer>{

	@Override
	public List<Reimbursement> getAll() {
		List<Reimbursement> reimList = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement st = conn.createStatement();
			st.execute("SELECT * FROM ers_reimbursement");
			ResultSet info = st.getResultSet();
			
			while(info.next())
			{
				Reimbursement r = new Reimbursement();
				r.setID(info.getInt(1));
				r.setAmount(info.getDouble(2));
				r.setSubmitTime(info.getDate(3));
				r.setResolveTime(info.getDate(4));
				r.setDescription(info.getString(5));
				r.setReciept(info.getBlob(6));
				r.setAuthor(info.getInt(7));
				r.setResolver(info.getInt(8));
				r.setStatus(info.getInt(9));
				r.setType(info.getInt(10));
				reimList.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimList;
	}

	@Override
	public Reimbursement findOne(Integer id) {
		
		Reimbursement reim = new Reimbursement();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (int)id);
			ResultSet info = ps.executeQuery();
			
			if(!info.next()) return null;
			
			reim.setID(info.getInt(1));
			reim.setAmount(info.getDouble(2));
			reim.setSubmitTime(info.getDate(3));
			reim.setResolveTime(info.getDate(4));
			reim.setDescription(info.getString(5));
			reim.setReciept(info.getBlob(6));
			reim.setAuthor(info.getInt(7));
			reim.setResolver(info.getInt(8));
			reim.setStatus(info.getInt(9));
			reim.setType(info.getInt(10));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return reim;
	}
	
	public List<Reimbursement> findByUserID(int user){
		List<Reimbursement> reimList = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user);
			ResultSet info = ps.executeQuery();
			while(info.next())
			{
				Reimbursement r = new Reimbursement();
				r.setID(info.getInt(1));
				r.setAmount(info.getDouble(2));
				r.setSubmitTime(info.getDate(3));
				r.setResolveTime(info.getDate(4));
				r.setDescription(info.getString(5));
				r.setReciept(info.getBlob(6));
				r.setAuthor(info.getInt(7));
				r.setResolver(info.getInt(8));
				r.setStatus(info.getInt(9));
				r.setType(info.getInt(10));
				reimList.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimList;
	}
	
	/*public List<Reimbursement> findByUserNameInProgress(int user){
		List<Reimbursement> reimList = new
	}*/

	@Override
	public Reimbursement save(Reimbursement obj) {
		Reimbursement reim = new Reimbursement();
		reim.setAmount(obj.getAmount());
		reim.setAuthor(obj.getAuthor());
		reim.setDescription(obj.getDescription());
		reim.setStatus(obj.getStatus());
		reim.setSubmitTime(obj.getSubmitTime());
		reim.setType(obj.getType());
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ers_reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id)"
					+ "values(?,?,?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "reimb_id";
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setDouble(1, reim.getAmount());
			ps.setDate(2, new java.sql.Date(obj.getSubmitTime().getTime()));
			ps.setString(3, obj.getDescription());
			ps.setInt(4, obj.getAuthor());
			ps.setInt(5, obj.getStatus());
			ps.setInt(6, obj.getType());
			
			int rows = ps.executeUpdate();
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					reim.setID(pk.getInt(1));
				}
				conn.commit();
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		};	
		return reim;
	}

	@Override
	public Reimbursement update(Reimbursement obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "UPDATE ers_reimbursement "
					+ "SET REIMB_RESOLVED = ?, REIMB_RESOLVER = ?, REIMB_STATUS_ID = ? "
					+ "WHERE REIMB_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, new java.sql.Date(obj.getResolveTime().getTime()));
			ps.setInt(2, obj.getResolver());
			ps.setInt(3, obj.getStatus());
			ps.setInt(4, obj.getID());
			ps.executeUpdate();
			conn.commit();
		}  catch (SQLException e) {
			e.printStackTrace();
		};
		
		return obj;
	}

	@Override
	public boolean isUnique(Reimbursement obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
