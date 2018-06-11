package com.ex.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.ex.pojos.Reimbursement;
import com.ex.pojos.User;
import com.ex.util.ConnectionFactory;

public class DaoImpl implements ReimbursementDao, UserDao {

	private static DaoImpl instance;

	public static DaoImpl getInstance() {
		if (instance == null) {
			instance = new DaoImpl();
		}
		return instance;
	}

	// USER DAO

	@Override
	public boolean insertUser(User usr) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO ers_users (ers_username, ers_password, ers_user_id) VALUES (?, ?, ?)");
			stmt.setString(1, usr.getPassword());
			stmt.setInt(1, usr.getId());

			if (!stmt.execute())// returns number of rows modified
				return stmt.getUpdateCount() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public User getUser(String username, String password) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ers_users WHERE ers_username = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new User(rs.getInt("ers_users_id"), rs.getString("ers_username"), rs.getString("user_firstname"),
						rs.getString("user_lastname"), rs.getString("user_email"), rs.getString("ers_password"),
						rs.getInt("user_role_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateUser(User usr) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement stmt = conn
					.prepareStatement("UPDATE ers_users SET pass = ?, username = ? WHERE email = ?");
			stmt.setString(1, usr.getPassword());
			stmt.setString(2, usr.getUsername());
			stmt.setString(3, usr.getEmail());

			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<User> getAllUsers() {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			List<User> users = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ers_users");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				users.add(new User(rs.getInt("ers_users_id"), rs.getString("ers_username"), rs.getString("ers_password"), 
						rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"), 
						rs.getInt("user_role_id")));
			}

			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// REIMBURSEMENT DAO
	public Reimbursement insertReimbursement(Reimbursement re) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			System.out.println(re);
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO ers_reimbursement (reimb_ammount, reimb_author, reimb_id, reimb_description) VALUES (?, ?, ?, ?)");
			stmt.setDouble(1, re.getAmount());
			stmt.setInt(2, re.getAuthor());
			stmt.setInt(3, re.getID());
			stmt.setString(4, re.getDescription());
			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;

	}

	public Reimbursement getReimbursement(int id) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ers_reimbursement WHERE reimb_id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_author"), rs.getInt("reimb_type_id"),
						rs.getInt("reimb_status"), rs.getDouble("reimb_amount"), rs.getInt("reimb_resolver"),
						rs.getString("reimb_description"), rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateReimbursement(Reimbursement re) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE ers_reimbursement SET reimb_status_id = ?, , reimb_resolved = ? WHERE reimb_id = ?");
			stmt.setInt(1, re.getStatus());
			stmt.setString(2, re.getResolved());
			stmt.setInt(3, re.getID());

			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public ArrayList<Reimbursement> getAllReimbursements() {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			ArrayList<Reimbursement> reimbursements = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ers_reimbursement");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_author"),
						rs.getInt("reimb_type_id"), rs.getInt("reimb_status_id"), rs.getDouble("reimb_ammount"),
						rs.getInt("reimb_resolver"), rs.getString("reimb_description"), rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved")));
			}

			return reimbursements;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Reimbursement> getAllSubmitted() {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			List<Reimbursement> reimbursements = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ers_reimbursement WHERE ers_status_id = 1");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_author"),
						rs.getInt("reimb_type_id"), rs.getInt("reimb_status"), rs.getDouble("reimb_amount"),
						rs.getInt("reimb_resolver"), rs.getString("reimb_description"), rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved")));

			}

			return reimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Reimbursement> getAllResolved() {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			List<Reimbursement> reimbursements = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement(
					"SELECT * FROM ers_reimbimbursement WHERE ers_status_id = 1 OR ers_status_id = 2");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_author"),
						rs.getInt("reimb_type_id"), rs.getInt("reimb_status"), rs.getDouble("reimb_amount"),
						rs.getInt("reimb_resolver"), rs.getString("reimb_description"), rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved")));
			}

			return reimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Reimbursement> getAllSubmittedForU(User usr) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			List<Reimbursement> reimbursements = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ers_reimbursement WHERE ers_username = ?");
			stmt.setString(1, usr.getEmail());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_author"),
						rs.getInt("reimb_type_id"), rs.getInt("reimb_status"), rs.getDouble("reimb_amount"),
						rs.getInt("reimb_resolver"), rs.getString("reimb_description"), rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved")));
			}

			return reimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public List<Reimbursement> getAllResolvedForU(User usr) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			List<Reimbursement> reimbursements = new ArrayList<>();
			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM ers_reimbursement WHERE ers_status_id = 1 AND ers_username = ?");
			stmt.setString(1, usr.getEmail());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_author"),
						rs.getInt("reimb_type_id"), rs.getInt("reimb_status"), rs.getDouble("reimb_amount"),
						rs.getInt("reimb_resolver"), rs.getString("reimb_description"), rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved")));
			}

			return reimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public User logIn(String username, String password) {

		User temp = new User();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("select * from ers_user where ers_username=? and ers_password=?");
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				temp = new User(rs.getInt("ers_user_id"), rs.getString("ers_username"), rs.getString("ers_password"),
						rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"),
						rs.getInt("user_role_id"));

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return temp;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reimbursement> getUserReimbursements(int userId) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			ArrayList<Reimbursement> reimbursements = new ArrayList<>();
			System.out.println("testdao");
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ers_reimbursement WHERE reimb_author = ?");
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_author"),
						rs.getInt("reimb_type_id"), rs.getInt("reimb_status_id"), rs.getDouble("reimb_ammount"),
						rs.getInt("reimb_resolver"), rs.getString("reimb_description"), rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved")));
				System.out.println(reimbursements.get(reimbursements.size()-1));
				
				System.out.println("test");
			}

			return reimbursements;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
