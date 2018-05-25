package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ex.pojos.BookAuthor;
import com.ex.util.ConnectionFactory;

public class BookAuthorDao implements Dao<BookAuthor, Integer>{

	public List<BookAuthor> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public BookAuthor findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public BookAuthor save(BookAuthor obj) {
<<<<<<< HEAD

=======
		int book = obj.getBook().getId();
		int author = obj.getAuthor().getId();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "insert into book_author(book_id, author_id) values(?,?)";
		
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, book);
			ps.setInt(2, author);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
>>>>>>> master
		return null;
	}

	public BookAuthor update(BookAuthor obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUnique(BookAuthor obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
