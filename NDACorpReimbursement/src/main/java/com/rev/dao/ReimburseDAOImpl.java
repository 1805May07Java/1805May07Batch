package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rev.pojos.ReimTypes;
import com.rev.pojos.Reimburse;
import com.rev.pojos.User;
import com.rev.util.ConnectionFactory;

public class ReimburseDAOImpl implements ReimburseDAO {

	@Override
	public ArrayList<Reimburse> getAllReimb() {
		ArrayList<Reimburse> r = new ArrayList<Reimburse>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select * from ERS_Reimbursement";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				Reimburse tmp = new Reimburse(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));

				r.add(tmp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public Reimburse addReimb(Reimburse r) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "INSERT INTO ERS_Reimbursement(REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)" + 
					"VALUES(?, sysdate, ?, ?, 0, ?, ?)"; //TO_DATE(?, 'DD-MON-YY')
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, r.getReimAmmount());
			//ps.setString(2, r.getDateSub());
			ps.setString(2, r.getNotes());
			ps.setInt(3, r.getAuthor());
			ps.setInt(4, r.getStatus());
			ps.setInt(5, r.getType());
			r.setReimId(ps.executeUpdate());
			if (!(r.getReimId() > 0)) {
				r = null;
			}

			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public void updateReimb(int id, int status, int person) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "UPDATE ERS_Reimbursement SET REIMB_RESOLVED = sysdate, REIMB_RESOLVER = ?, REIMB_STATUS_ID = ? WHERE REIMB_ID = ?";
			System.out.println("in dao");		
			PreparedStatement ps = conn.prepareStatement(query);
			//ps.setString(1, r.getDateRes());
			ps.setInt(1, person);
			ps.setInt(2, status);
			ps.setInt(3, id);

			int q = ps.executeUpdate();
			System.out.println("afterdao");
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getType(int typeId) {
		String t = "";
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select REIMB_TYPE from ERS_REIMBURSEMENT_TYPE WHERE REIMB_TYPE_ID = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, typeId);
			ResultSet rs = ps.executeQuery();
			rs.next();
				t = rs.getString(1);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return t;
	}

	@Override
	public String getStatus(int statusId) {
		String s = "";
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select REIMB_STATUS from ERS_REIMBURSEMENT_STATUS WHERE REIMB_STATUS_ID = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, statusId);
			ResultSet rs = ps.executeQuery();
			rs.next();
				s = rs.getString(1);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return s;
	}

	@Override
	public Reimburse getReimb(int reimId) {
		Reimburse r = new Reimburse();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select * from ERS_Reimbursement WHERE REIMB_ID = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, reimId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			r = new Reimburse(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public ArrayList<ReimTypes> getAllReimbTypes() {
		ArrayList<ReimTypes> r = new ArrayList<ReimTypes>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "select * from ERS_REIMBURSEMENT_TYPE";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				ReimTypes tmp = new ReimTypes(rs.getInt(1), rs.getString(2));

				r.add(tmp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public ArrayList<Reimburse> getAllReimb(int userID) {
		ArrayList<Reimburse> r = new ArrayList<Reimburse>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select * from ERS_Reimbursement where REIMB_AUTHOR = " + userID;

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				Reimburse tmp = new Reimburse(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));

				r.add(tmp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public ArrayList<Reimburse> getAprReim() {
		ArrayList<Reimburse> r = new ArrayList<Reimburse>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select * from ERS_Reimbursement where REIMB_STATUS_ID = 2";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				Reimburse tmp = new Reimburse(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));

				r.add(tmp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public ArrayList<Reimburse> getDenReim() {
		ArrayList<Reimburse> r = new ArrayList<Reimburse>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select * from ERS_Reimbursement where REIMB_STATUS_ID = 3";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				Reimburse tmp = new Reimburse(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));

				r.add(tmp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public ArrayList<Reimburse> getPendReim() {
		ArrayList<Reimburse> r = new ArrayList<Reimburse>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select * from ERS_Reimbursement where REIMB_STATUS_ID = 1";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				Reimburse tmp = new Reimburse(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));

				r.add(tmp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

}
