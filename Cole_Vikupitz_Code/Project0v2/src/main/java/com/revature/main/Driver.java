/*
 * Driver.java
 * Author: Cole Vikupitz
 */

package com.revature.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.util.ConnectionFactory;



public class Driver {

	public static void main(String[] args) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String query = "SELECT * FROM Account_Type";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next())
				System.out.println(rs.getString(2));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


/*

 List<Book> books = new ArrayList<Book>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
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
 */
