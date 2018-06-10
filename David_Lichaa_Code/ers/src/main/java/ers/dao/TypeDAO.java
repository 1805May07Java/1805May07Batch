package ers.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ers.pojos.Type;
import ers.util.ConnectionFactory;

public class TypeDAO {
	public List<Type> getAll() {
		List<Type> types = new ArrayList<Type>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_reimbursement_type";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				Type type = new Type();
				type.setId(rs.getInt(1));
				type.setType(rs.getString(2));
				types.add(type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return types;
	}
}
