package com.ex.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Author;
import com.ex.util.ConnectionFactory;

public class AuthorDao implements Dao<Author, Integer> {

	public List<Author> getAll() {
		
		List<Author> authors = new ArrayList<Author>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from author";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) { //Author: author_id, firstname, lastname, bio 
				Author temp = new Author();
				temp.setId(rs.getInt(1)); //can access by name or index(starts with 1)
				temp.setFirstName(rs.getString(2));
				temp.setLastName(rs.getString(3));
				temp.setBio(rs.getString(4));
				authors.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return authors;
		
	}

	public Author findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Author save(Author obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Author update(Author obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
