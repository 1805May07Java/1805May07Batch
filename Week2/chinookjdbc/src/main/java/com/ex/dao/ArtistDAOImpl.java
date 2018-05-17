package com.ex.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ex.pojos.Artist;
import com.ex.util.ConnectionFactory;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artist addArtist(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artist updateArtist(int id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
