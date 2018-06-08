package reimburse.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import reimburse.jdbc.ConnectionFactory;
import reimburse.pojo.Type;

public class TypeLookupImpl implements LookupDAO<Type> {

	ArrayList<Type> list = new ArrayList<Type>();
		
	@Override
	public ArrayList<Type> getAll() {
		// TODO Auto-generated method stub
		list.clear();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from ERS_REIMBURSEMENT_TYPE";	
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				Type temp = new Type();
				temp.setId(rs.getInt(1)); //can access by name or index(starts with 1)
				temp.setType(rs.getString(2));
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String get(int id) {
		for(Type t : list) {
			if(id == t.getId()) {
				return t.getType();
			}
		}
		return null;
	}

	@Override
	public int get(String type) {
		for(Type t : list) {
			if(type.equalsIgnoreCase(t.getType())) {
				return t.getId();
			}
		}
		return -1;
	}

}
