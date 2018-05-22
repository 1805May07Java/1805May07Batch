package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ex.pojos.Artist;
import com.ex.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class ArtistDAOImpl implements ArtistDAO{

	//STATEMENT
	@Override
	public ArrayList<Artist> getAll() {
		ArrayList<Artist> artists = new ArrayList<Artist>();
		try(Connection conn =
				ConnectionFactory.getInstance().getConnection();){
			
			String query = "select * from artist";
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Artist temp = new Artist();
				temp.setId(rs.getInt("ARTISTID")); //can access by name or index(starts with 1)
				temp.setName(rs.getString(2));
				artists.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artists;
	}

	@Override
	public Artist getById(int id) {
		Artist artist = new Artist();
		
		try(Connection conn = 
				ConnectionFactory.getInstance().getConnection()){
			String query = "select * from artist where artistid = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			while(info.next()) {
				artist.setId(info.getInt(1));
				artist.setName(info.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artist;
	}

	@Override
	public Artist addArtist(String name) {
		Artist art = new Artist();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "insert into artist (NAME) values (?)";
			
			String[] keys = new String[1];
			keys[0] = "artistid";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setString(1, name);
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					art.setId(pk.getInt(1));
				}
				art.setName(name);
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return art;
	}

	@Override
	public void updateArtist(int id, String name) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "update artist set name = ? where artistid = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, id);
		System.out.println( ps.executeUpdate()) ;
		//	System.out.println(row + "rows affected");
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Artist> getAllStoredProc() {
		ArrayList<Artist> artists = new ArrayList<Artist>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "{call get_all_artists(?) }";
			
			CallableStatement cs = conn.prepareCall(query);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				artists.add(new Artist(rs.getInt(1), rs.getString(2)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artists;
	}

}
