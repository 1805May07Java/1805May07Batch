package reimburse.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import reimburse.jdbc.ConnectionFactory;
import reimburse.pojo.Status;

public class StatusLookupImpl implements LookupDAO<Status>{

	ArrayList<Status> list = new ArrayList<Status>();;
	
	@Override
	public ArrayList<Status> getAll() {
		// TODO Auto-generated method stub
		list.clear();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from ERS_REIMBURSEMENT_STATUS";	
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				Status temp = new Status();
				temp.setId(rs.getInt(1)); //can access by name or index(starts with 1)
				temp.setStatus(rs.getString(2));
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String get(int id) {
		for(Status s : list) {
			if(id == s.getId()) {
				return s.getStatus();
			}
		}
		return null;
	}

	@Override
	public int get(String status) {
		for(Status s : list) {
			if(status.equalsIgnoreCase(s.getStatus())) {
				return s.getId();
			}
		}
		return -1;
	}
}
