package com.ex.repository;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.beans.Genre;
import com.ex.util.ConnectionUtil;

public class GenreRepositoryHibernate implements GenreRepository{

	@Override
	public Genre addGenre(Genre g) {	

		try(Session session = ConnectionUtil.getSession()) {
			Transaction tx = session.beginTransaction();
			int id = (Integer) session.save(g);
			g.setId(id);
			tx.commit();
		}	
		return g;
	}

	@Override
	public List<Genre> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
