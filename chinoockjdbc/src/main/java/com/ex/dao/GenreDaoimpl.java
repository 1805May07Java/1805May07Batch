package com.ex.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import com.ex.pojos.Artist;
import com.ex.pojos.Genre;
import com.ex.util.ConnectionFactory;

public class GenreDaoimpl implements GenreDAO{

	@Override
	public ArrayList<Genre> getAll() {
		ArrayList<Genre> genres = new ArrayList<Genre>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select * from genre";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				Genre tmp = new Genre();
				tmp.setId(rs.getInt("GENREID"));
				tmp.setName(rs.getString(2));

				genres.add(tmp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}




		return genres;
	}

	@Override
	public Genre getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genre addArtist(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genre updateArtist(int id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
