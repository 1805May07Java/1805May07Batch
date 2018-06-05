package com.major.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.major.pojos.UserRoles;
import com.major.util.ConnectionFactory;

public class UserRoleDaoImpl implements UserRoleDao {
	final static Logger logger = Logger.getLogger(UserRoleDaoImpl.class);
	@Override
	public UserRoles getType(int id) 
	{
		UserRoles output = new UserRoles();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "select * from ERS_USER_ROLES where USER_ROLE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				output.setId(id);
				output.setRole(rs.getString("USER_ROLE"));
			}
			
		} 
		catch (SQLException e)
		{
			logger.debug("UserRolesDao DAO issue", e);
		}
		return output;
	}

	@Override
	public int getId(String input) {
		int out = 0;
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "select * from ERS_USER_ROLES where USER_ROLE = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, input);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				out = rs.getInt("USER_ROLE_ID");
			}
		} 
		catch (SQLException e) 
		{
			logger.debug("UserRolesDao DAO issue", e);
		}
		return out;
	}

	@Override
	public ArrayList<UserRoles> getAllRoles() {
		ArrayList<UserRoles> output = new ArrayList<UserRoles>();
		UserRoles temp = new UserRoles();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "select * from ERS_USER_ROLES";
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) 
			{
				temp.setId(rs.getInt("USER_ROLE_ID"));
				temp.setRole(rs.getString("USER_ROLE"));
				output.add(temp);
			}
			
		} 
		catch (SQLException e)
		{
			logger.debug("UserRolesDao DAO issue", e);
		}
		return output;
	}

}
