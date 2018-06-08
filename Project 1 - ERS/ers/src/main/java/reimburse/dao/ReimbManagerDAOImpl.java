package reimburse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import reimburse.jdbc.ConnectionFactory;
import reimburse.pojo.Reimbursement;
import reimburse.pojo.User;

public class ReimbManagerDAOImpl implements ReimbDAO {

	@Override
	public ArrayList<Reimbursement> getAll(int id) {
		ArrayList<Reimbursement> list = new ArrayList<>();
		UserDAOImpl userdao = new UserDAOImpl();
		userdao.getAll();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from ers_reimbursement order by REIMB_SUBMITTED desc";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt("REIMB_ID"));
				temp.setAmount(rs.getDouble("REIMB_AMOUNT"));
				temp.setSubmitted(rs.getTimestamp("REIMB_SUBMITTED"));
				temp.setResolved(rs.getTimestamp("REIMB_RESOLVED"));
				temp.setDescription(rs.getString("REIMB_DESCRIPTION"));
				temp.setAuthor(userdao.getUser(rs.getInt("REIMB_AUTHOR")));
				temp.setResolver(userdao.getUser(rs.getInt("REIMB_RESOLVER")));
				temp.setStatus(rs.getInt("REIMB_STATUS_ID"));
				temp.setType(rs.getInt("REIMB_TYPE_ID"));
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Reimbursement> getAllByStatus(int id, String status) {
		ArrayList<Reimbursement> list = new ArrayList<>();
		UserDAOImpl userdao = new UserDAOImpl();
		StatusLookupImpl statusdao = new StatusLookupImpl();
		userdao.getAll();
		statusdao.getAll();

		int statusid = statusdao.get(status);
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from ers_reimbursement where REIMB_STATUS_ID = "+statusid+" order by REIMB_SUBMITTED desc";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt("REIMB_ID"));
				temp.setAmount(rs.getDouble("REIMB_AMOUNT"));
				temp.setSubmitted(rs.getTimestamp("REIMB_SUBMITTED"));
				temp.setResolved(rs.getTimestamp("REIMB_RESOLVED"));
				temp.setDescription(rs.getString("REIMB_DESCRIPTION"));
				temp.setAuthor(userdao.getUser(rs.getInt("REIMB_AUTHOR")));
				temp.setResolver(userdao.getUser(rs.getInt("REIMB_RESOLVER")));
				temp.setStatus(rs.getInt("REIMB_STATUS_ID"));
				temp.setType(rs.getInt("REIMB_TYPE_ID"));
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void resolveTicket(int reimbid, int managerid, boolean approved) {
		UserDAOImpl userdao = new UserDAOImpl();
		StatusLookupImpl statusdao = new StatusLookupImpl();
		userdao.getAll();
		statusdao.getAll();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			Timestamp resolved = new Timestamp(System.currentTimeMillis());
			int statusid = approved ? statusdao.get("approved") : statusdao.get("denied");
			
			String query = "update ERS_REIMBURSEMENT "
					+ "set REIMB_RESOLVED = ?, REIMB_RESOLVER = ?, REIMB_STATUS_ID = ? "
					+ "where REIMB_ID = ? ";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setTimestamp(1, resolved);
			ps.setInt(2, managerid);
			ps.setInt(3, statusid);
			ps.setInt(4, reimbid);
			ps.execute();
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
