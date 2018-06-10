package ers.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ers.pojos.Reimbursement;
import ers.util.ConnectionFactory;

public class ReimbursementDAO {
	public List<Reimbursement> getAll() {
		ArrayList<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_reimbursement";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				//TODO: when loading null values, if RESOLVED is null, "" is extracted. Every other string is "null"
				Reimbursement r = new Reimbursement();
				r.setId(rs.getInt(1));
				r.setAmount(rs.getInt(2));
				r.setSubmitted(rs.getDate(3).toString());
				String desc = rs.getString(5);
				if (rs.wasNull()) {
					r.setDescription("0");
				} else {
					r.setDescription(desc);
				}
				r.setAuthor(rs.getInt(7));
				r.setResolver(rs.getInt(8));
				r.setStatusId(rs.getInt(9));
				r.setTypeId(rs.getInt(10));
				Date dateResolved = rs.getDate(4);
				if (rs.wasNull()) {
					r.setResolved("0");
				} else {
					r.setResolved(dateResolved.toString());
				}
				reimbs.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}
	
	public List<Reimbursement> getAllByUser(int userId) {
		ArrayList<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_reimbursement where reimb_author = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//TODO: when loading null values, if RESOLVED is null, "" is extracted. Every other string is "null"
				Reimbursement r = new Reimbursement();
				r.setId(rs.getInt(1));
				r.setAmount(rs.getInt(2));
				r.setSubmitted(rs.getDate(3).toString());
				String desc = rs.getString(5);
				if (rs.wasNull()) {
					r.setDescription("0");
				} else {
					r.setDescription(desc);
				}
				r.setAuthor(rs.getInt(7));
				r.setResolver(rs.getInt(8));
				r.setStatusId(rs.getInt(9));
				r.setTypeId(rs.getInt(10));
				Date dateResolved = rs.getDate(4);
				if (rs.wasNull()) {
					r.setResolved("0");
				} else {
					r.setResolved(dateResolved.toString());
				}
				reimbs.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}
	public String getStatus(int id) {
		String status = "";
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select reimb_status from ers_reimbursement_status where reimb_status_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getString(1);
		} catch (SQLException e) {
			
		}
		return status;
	}
	
	public void insertRequest(Reimbursement reimb) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call ERS_INSERT_REIMB (?, ?, ?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, reimb.getAmount());
			cs.setString(2, reimb.getDescription());
			cs.setInt(3, reimb.getAuthor());
			cs.setInt(4, reimb.getTypeId());
			cs.execute();
		} catch (SQLException e) {
			
		}
	}

	public void modifyStatus(int reimbursementId, int resolverId, int newStatus) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "update ERS_REIMBURSEMENT set reimb_resolved = SYSDATE, reimb_resolver = ?," 
					 +   "reimb_status_id = ? where REIMB_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, resolverId);
			ps.setInt(2, newStatus);
			ps.setInt(3,  reimbursementId);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
