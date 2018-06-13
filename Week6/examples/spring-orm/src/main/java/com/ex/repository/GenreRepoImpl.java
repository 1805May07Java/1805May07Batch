package com.ex.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.beans.Genre;

@Repository
@Transactional
public class GenreRepoImpl implements GenreRepository{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Genre> getAll() {
		Session s = sf.getCurrentSession();
		return s.createCriteria(Genre.class).list();
	}

	@Override
	public Genre getById(int id) {
		return (Genre) sf.getCurrentSession().get(Genre.class, id);
	}

	@Override
	public Genre add(Genre g) {
		int id = (Integer) sf.getCurrentSession().save(g);
		g.setId(id);
		return g;
	}

}
