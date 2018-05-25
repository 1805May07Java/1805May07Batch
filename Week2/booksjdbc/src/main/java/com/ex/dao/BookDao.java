package com.ex.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Book;
import com.ex.util.ConnectionFactory;

public class BookDao implements Dao<Book, Integer> {

	public List<Book> getAll() {
		List<Book> books = new ArrayList<Book>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from book";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {// book_id, isbn, title, price, genre
				Book temp = new Book();
				temp.setId(rs.getInt(1));
				temp.setIsbn(rs.getString(2));
				temp.setTitle(rs.getString(3));
				temp.setPrice(rs.getDouble(4));
				temp.setGenreId(rs.getInt(5));
				books.add(temp);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	public Book findOne(Integer id) {
		Book book = new Book();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from book where book_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();

			info.next();
//			book.setId();
//			book.setIsbn(2);
//			book.setTitle(3);
//			book.setPrice(4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	public Book save(Book obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Book update(Book book) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		    conn.setAutoCommit(false);

		    String query = "update book set isbn = ?, title = ?, price = ?, genre = ? where book_id =?";
		    PreparedStatement ps = conn.prepareStatement(query);

		    ps.setString(1, book.getIsbn());
		    ps.setString(2,book.getTitle());
		    ps.setDouble(3,book.getPrice());
		    ps.setInt(4,book.getGenreId());
		    ps.setInt(5,book.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

}
