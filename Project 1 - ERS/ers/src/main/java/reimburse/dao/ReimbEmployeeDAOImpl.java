package reimburse.dao;

import java.sql.CallableStatement;
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

public class ReimbEmployeeDAOImpl implements ReimbDAO {

	@Override
	public ArrayList<Reimbursement> getAll(int id) {
		ArrayList<Reimbursement> list = new ArrayList<>();
		UserDAOImpl userdao = new UserDAOImpl();
		userdao.getAll();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from ERS_REIMBURSEMENT where REIMB_AUTHOR = " + id;
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

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			int statusid = statusdao.get(status);
			String query = "select * "
					+ "from ERS_REIMBURSEMENT "
					+ "where REIMB_AUTHOR = " + id + "AND REIMB_STATUS_ID = " + statusid;
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


	public void insertTicket(double amount, /*Timestamp submitted,*/ String description, User author, String type) {
		StatusLookupImpl slist = new StatusLookupImpl();
		TypeLookupImpl tlist = new TypeLookupImpl();
		slist.getAll();
		tlist.getAll();
		Timestamp submitted = new Timestamp(System.currentTimeMillis());
		int statusid = slist.get("pending");
		int typeid = tlist.get(type); 
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);

			String[] keys = new String[7];
			keys[0] = "REIMB_ID";
			keys[1] = "REIMB_AMOUNT";
			keys[2] = "REIMB_SUBMITTED";
			keys[3] = "REIMB_DESCRIPTION";
			keys[4] = "REIMB_AUTHOR";
			keys[5] = "REIMB_STATUS_ID";
			keys[6] = "REIMB_TYPE_ID";

//			String query = "insert into ERS_REIMBURSEMENT "
//					+ "(REIMB_AMOUNT,REIMB_SUBMITTED,REIMB_DESCRIPTION,REIMB_AUTHOR,REIMB_STATUS_ID,REIMB_TYPE_ID) "
//					+ "values (?,?,?,?,?,?)";
//			PreparedStatement ps = conn.prepareStatement(query, keys);
//			ps.setDouble(1, amount);
//			ps.setTimestamp(2, submitted);
//			ps.setString(3, description);
//			ps.setInt(4, author.getId());
//			ps.setInt(5, statusid);
//			ps.setInt(6, typeid);
			
			String call = "{call insert_reimb(?,?,?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(call);
			cs.setDouble(1, amount);
			cs.setTimestamp(2, submitted);
			cs.setString(3, description);
			cs.setInt(4, author.getId());
			cs.setInt(5, statusid);
			cs.setInt(6, typeid);
			cs.execute();
			conn.commit();
//			int rows = cs.executeUpdate();
//			if(rows != 0) {
//				ResultSet pk = ps.getGeneratedKeys();
//				while(pk.next()) {
//					Reimbursement temp = new Reimbursement();
//					temp.setId(pk.getInt(1));
//					temp.setAmount(pk.getDouble(2));
//					temp.setSubmitted(pk.getTimestamp(3));
//					temp.setDescription(pk.getString(4));
//					temp.setAuthor(author);
//					temp.setStatus(pk.getInt(6));
//					temp.setType(pk.getInt(7));
//					conn.commit();
//					return temp;
//				}
//			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		return null;
	}


}
