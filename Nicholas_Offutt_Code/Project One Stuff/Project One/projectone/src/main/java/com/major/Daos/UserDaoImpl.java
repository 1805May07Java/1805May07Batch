package com.major.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.major.pojos.ErsUser;
import com.major.util.ConnectionFactory;

public class UserDaoImpl implements UserDao {

	final static Logger logger = Logger.getLogger(UserDaoImpl.class);
	@Override
	public ErsUser getByName(String userName) 
	{
		ErsUser temp = new ErsUser();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			
			String sql = "select * from ERS_USER where ERS_USER_NAME = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) 
			{
				temp.setId(rs.getInt("ERS_USER_ID"));
				temp.setUserName(rs.getString("ERS_USER_NAME"));
				temp.setPassword(rs.getString("ERS_PASSWORD"));
				temp.setFirstName(rs.getString("FIRST_NAME"));
				temp.setLastName(rs.getString("LAST_NAME"));
				temp.setEmail(rs.getString("USER_EMAIL"));
				temp.setRoleId(rs.getInt("USER_ROLE_ID"));
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.debug("User DAO issue", e);
		}
		
		return temp;
		
	}

	@Override
	public ArrayList<ErsUser> getAllUsers() 
	{
		ArrayList<ErsUser> output = new ArrayList<ErsUser>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "select * from ERS_USER";
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) 
			{
				ErsUser temp = new ErsUser();
				temp.setId(rs.getInt("ERS_USER_ID"));
				temp.setUserName(rs.getString("ERS_USER_NAME"));
				temp.setPassword("dummy");
				temp.setFirstName(rs.getString("FIRST_NAME"));
				temp.setLastName(rs.getString("LAST_NAME"));
				temp.setEmail(rs.getString("USER_EMAIL"));
				temp.setRoleId(rs.getInt("USER_ROLE_ID"));
				output.add(temp);
			}
			
		} 
		catch (SQLException e)
		{
			logger.debug("User DAO issue", e);
		}
		return output;
	}

	@Override
	public boolean isFree(String userName, String email) {

		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			
			String sql1 = "select * from ERS_USER where ERS_USER_NAME = ?";
			String sql2 = "select * from ERS_USER where USER_EMAIL = ?";
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setString(1, userName);
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setString(1, email);
			
			ResultSet rs1 = ps1.executeQuery();
			
			ResultSet rs2 = ps2.executeQuery();
			if(rs1.next())
			{
				return false;
			}
			if(rs2.next()) 
			{
				return false;
			}
			
		} catch (SQLException e) {
			logger.debug("User DAO issue", e);
		}
		
		return true;
	}

	@Override
	public ErsUser createUser(ErsUser obj) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			String[] keys = new String[1];
			keys[0] = "ERS_USER_ID";
			String sql = "insert into ERS_USER (ERS_USER_NAME, ERS_PASSWORD, FIRST_NAME, "
					+ "LAST_NAME, USER_EMAIL, USER_ROLE_ID) values (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			ps.setString(1, obj.getUserName());
			ps.setString(2, obj.getPassword());
			ps.setString(3, obj.getFirstName());
			ps.setString(4, obj.getLastName());
			ps.setString(5, obj.getEmail());
			ps.setInt(6, obj.getRoleId());
			int rows = ps.executeUpdate();
			if(rows!=0) 
			{
				ResultSet rs = ps.getGeneratedKeys();
				obj.setId(rs.getInt(1));
			}
			conn.commit();
		} catch (SQLException e) 
		{
			
			logger.debug("User DAO issue", e);
		}
		
		
		return obj;
	}

	@Override
	public ErsUser updateUser(ErsUser obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			String sql = "update ERS_USER set ERS_USER_NAME = ?, ERS_PASSWORD = ?, FIRST_NAME = ?, "
					+ "LAST_NAME = ?, USER_EMAIL = ?, USER_ROLE_ID = ? where ERS_USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, obj.getUserName());
			ps.setString(2, obj.getPassword());
			ps.setString(3, obj.getFirstName());
			ps.setString(4, obj.getLastName());
			ps.setString(5, obj.getEmail());
			ps.setInt(6, obj.getRoleId());
			ps.setInt(7, obj.getId());
			int rows = ps.executeUpdate();
			if(rows!=0) 
			{
				return obj;
			}
			conn.commit();
		} catch (SQLException e) 
		{
			logger.debug("User DAO issue", e);
		}
		
		
		return null;
	}

	@Override
	public ErsUser getById(int id) 
	{
		ErsUser temp = new ErsUser();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			
			String sql = "select * from ERS_USER where ERS_USER_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				temp.setId(rs.getInt("ERS_USER_ID"));
				temp.setUserName(rs.getString("ERS_USER_NAME"));
				temp.setPassword(rs.getString("ERS_PASSWORD"));
				temp.setFirstName(rs.getString("FIRST_NAME"));
				temp.setLastName(rs.getString("LAST_NAME"));
				temp.setEmail(rs.getString("USER_EMAIL"));
				temp.setRoleId(rs.getInt("USER_ROLE_ID"));
			}
			
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.debug("User DAO issue", e);
		}
		
		return temp;
	}

}
